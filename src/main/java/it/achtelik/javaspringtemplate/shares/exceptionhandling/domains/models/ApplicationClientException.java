package it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models;

public class ApplicationClientException extends AbstractApplicationRuntimeException {
    public ApplicationClientException(String message) {
        super(message, message, null);
    }

    public ApplicationClientException(String clientMessage, String serverMessage, Throwable cause) {
        super(clientMessage, serverMessage, cause);
    }
}
