package org.spacetrader.main.stub;


public class SerializationException extends Exception {
    private static final long serialVersionUID = 1L;

    public SerializationException() {
        super();
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }
}
