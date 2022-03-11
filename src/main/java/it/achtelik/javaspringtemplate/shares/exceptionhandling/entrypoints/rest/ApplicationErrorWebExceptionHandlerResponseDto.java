package it.achtelik.javaspringtemplate.shares.exceptionhandling.entrypoints.rest;

import java.time.Instant;

public record ApplicationErrorWebExceptionHandlerResponseDto(Instant occurredAt, String errorId, String clientMessage) {
}
