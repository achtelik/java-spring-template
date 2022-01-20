package it.achtelik.javaspringtemplate.commons.exceptionhandling.domain.models;

import java.util.UUID;

public class AbstractApplicationRuntimeException extends RuntimeException {
    private final UUID uuid;
    private final int httpStatusCode;
    private final String clientMessage;

    public AbstractApplicationRuntimeException(int httpStatusCode, String clientMessage,
                                               String serverMessage, Throwable cause) {
        super(serverMessage, cause);
        this.uuid = UUID.randomUUID();
        this.httpStatusCode = httpStatusCode;
        this.clientMessage = clientMessage;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getClientMessage() {
        return clientMessage;
    }
}
