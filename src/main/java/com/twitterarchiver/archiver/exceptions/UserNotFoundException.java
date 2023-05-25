package com.twitterarchiver.archiver.exceptions;

/**
 * Exception to throw when a given user handle is not found in the database or on Twitter.
 */
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5178612907878867105L;

    /**
     * Exception with no message or cause.
     */
    public UserNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
