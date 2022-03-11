package it.achtelik.javaspringtemplate.shares.exceptionhandling.entrypoints.rest;

import it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models.AbstractApplicationRuntimeException;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ApplicationErrorWebExceptionHandlerDtoMapper {

    public ApplicationErrorWebExceptionHandlerResponseDto toResponseDto(Instant instant, AbstractApplicationRuntimeException exception) {
        return new ApplicationErrorWebExceptionHandlerResponseDto(instant, exception.getErrorId().toString(), exception.getClientMessage());
    }
}
