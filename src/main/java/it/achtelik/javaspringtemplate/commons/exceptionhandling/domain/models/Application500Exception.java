package it.achtelik.javaspringtemplate.commons.exceptionhandling.domain.models;

public class Application500Exception extends AbstractApplicationRuntimeException {
    public Application500Exception(String message, Throwable cause) {
        this(message, message, cause);
    }

    public Application500Exception(String clientMessage, String serverMessage, Throwable cause) {
        super(500, clientMessage, serverMessage, cause);
    }
}
