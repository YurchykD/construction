package com.solvd.construction_company.exception;

public class IdException extends Exception{
    public IdException() {
        super("Incorrect ID");
    }

    public IdException(String message) {
        super(message);
    }

    public IdException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdException(Throwable cause) {
        super(cause);
    }

    public IdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
