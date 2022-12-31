package com.solvd.construction_company.exception;

public class CarNumberException extends Exception {
    public CarNumberException() {
        super("Wrong car number");
    }

    public CarNumberException(String message) {
        super(message);
    }

    public CarNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNumberException(Throwable cause) {
        super(cause);
    }

    public CarNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
