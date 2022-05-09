package it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models;

public class ApplicationServerException extends AbstractApplicationRuntimeException {
    public ApplicationServerException(String message, Throwable cause) {
        this(message, message, cause);
    }

    public ApplicationServerException(String clientMessage, String serverMessage, Throwable cause) {
        super(clientMessage, serverMessage, cause);
    }
}
