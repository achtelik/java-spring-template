package it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models;

import java.util.UUID;

public class AbstractApplicationRuntimeException extends RuntimeException {
    private final UUID errorId;
    private final String clientMessage;

    public AbstractApplicationRuntimeException(String clientMessage,
                                               String serverMessage, Throwable cause) {
        super(serverMessage, cause);
        this.errorId = UUID.randomUUID();
        this.clientMessage = clientMessage;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public String getClientMessage() {
        return clientMessage;
    }
}
