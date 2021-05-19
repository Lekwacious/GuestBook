package com.lekwacious.guestbook.exception;

public class GuestBookException extends RuntimeException{
    public GuestBookException(String message) {
        super(message);
    }

    public GuestBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuestBookException(Throwable cause) {
        super(cause);
    }

    public GuestBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
