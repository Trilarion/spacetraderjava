package org.spacetrader.util;


// TODO describe usage
public class SerializationException extends Exception {

    private static final long serialVersionUID = 1L;

    public SerializationException() {}

    public SerializationException(final String message) {
        super(message);
    }

    public SerializationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SerializationException(final Throwable cause) {
        super(cause);
    }
}
