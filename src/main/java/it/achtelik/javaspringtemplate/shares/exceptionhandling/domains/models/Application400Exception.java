package it.achtelik.javaspringtemplate.shares.exceptionhandling.domains.models;

public class Application400Exception extends AbstractApplicationRuntimeException {
    public Application400Exception(String message) {
        super(400, message, message, null);
    }

    public Application400Exception(String clientMessage, String serverMessage, Throwable cause) {
        super(400, clientMessage, serverMessage, cause);
    }
}
