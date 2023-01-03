package com.solvd.construction_company.exception;

public class FloorException extends Exception {
    public FloorException() {
        super("Error in setting floors");
    }

    public FloorException(String message) {
        super(message);
    }

    public FloorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FloorException(Throwable cause) {
        super(cause);
    }

    public FloorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
