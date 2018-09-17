package com.tosit.framework.mvc.ex;

public class MVCException extends RuntimeException {
    public MVCException() {
    }

    public MVCException(String message) {
        super(message);
    }

    public MVCException(String message, Throwable cause) {
        super(message, cause);
    }

    public MVCException(Throwable cause) {
        super(cause);
    }

    public MVCException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
