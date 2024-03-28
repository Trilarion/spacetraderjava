package org.spacetrader.util;


// TODO describe usage
public class SerializationException extends Exception {

    private static final long serialVersionUID = 1L;

    public SerializationException() {}

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
