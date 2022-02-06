package it.achtelik.javaspringtemplate.commons.exceptionhandling.entrypoints.rest;

import it.achtelik.javaspringtemplate.commons.exceptionhandling.domain.models.AbstractApplicationRuntimeException;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ApplicationErrorWebExceptionHandlerDtoMapper {

    public ApplicationErrorWebExceptionHandlerResponseDto toResponseDto(Instant instant, AbstractApplicationRuntimeException exception) {
        return new ApplicationErrorWebExceptionHandlerResponseDto(instant, exception.getErrorId().toString(), exception.getClientMessage());
    }
}
