package it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models;

import java.util.UUID;

public class AbstractApplicationRuntimeException extends RuntimeException {
    private final UUID errorId;
    private final int httpStatusCode;
    private final String clientMessage;

    public AbstractApplicationRuntimeException(int httpStatusCode, String clientMessage,
                                               String serverMessage, Throwable cause) {
        super(serverMessage, cause);
        this.errorId = UUID.randomUUID();
        this.httpStatusCode = httpStatusCode;
        this.clientMessage = clientMessage;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getClientMessage() {
        return clientMessage;
    }
}
