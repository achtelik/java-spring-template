package it.achtelik.javaspringtemplate.shares.exceptionhandling.entrypoints.rest;

import it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models.AbstractApplicationRuntimeException;
import it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models.ApplicationClientException;
import it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models.ApplicationServerException;
import it.achtelik.javaspringtemplate.shares.time.applications.services.TimeApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class ApplicationErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationErrorWebExceptionHandler.class);
    private final TimeApplicationService timeApplicationService;
    private final ApplicationErrorWebExceptionHandlerDtoMapper applicationErrorWebExceptionHandlerDtoMapper;


    public ApplicationErrorWebExceptionHandler(ErrorAttributes errorAttributes,
                                               WebProperties webProperties,
                                               ApplicationContext applicationContext,
                                               ServerCodecConfigurer serverCodecConfigurer,
                                               TimeApplicationService timeApplicationService,
                                               ApplicationErrorWebExceptionHandlerDtoMapper applicationErrorWebExceptionHandlerDtoMapper) {
        super(errorAttributes, webProperties.getResources(), applicationContext);
        this.setMessageWriters(serverCodecConfigurer.getWriters());
        this.timeApplicationService = timeApplicationService;
        this.applicationErrorWebExceptionHandlerDtoMapper = applicationErrorWebExceptionHandlerDtoMapper;
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::handleError);
    }

    private Mono<ServerResponse> handleError(ServerRequest serverRequest) {
        var applicationException = convertToApplicationRuntimerException(getError(serverRequest));
        LOGGER.error("[{}] {}", applicationException.getErrorId(), applicationException.getMessage(), applicationException);
        return ServerResponse.status(mapExceptionToHttpStatusCode(applicationException))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(applicationErrorWebExceptionHandlerDtoMapper.toResponseDto(timeApplicationService.now(), applicationException)));
    }

    private AbstractApplicationRuntimeException convertToApplicationRuntimerException(Throwable throwable) {
        return (throwable instanceof AbstractApplicationRuntimeException tmpAbstractApplicationRuntimeException
                ? tmpAbstractApplicationRuntimeException
                : new ApplicationServerException("Unexpected server error!", throwable));
    }

    @Override
    protected void logError(ServerRequest request, ServerResponse response, Throwable throwable) {
        // See handleError method.
    }

    private HttpStatus mapExceptionToHttpStatusCode(Exception exception) {
        if (exception instanceof ApplicationClientException) {
            return HttpStatus.BAD_REQUEST;
        } else if (exception instanceof ApplicationServerException) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
