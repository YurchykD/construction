package com.solvd.construction_company.exception;

public class PhoneNumberException extends Exception{

    public PhoneNumberException() {
        super("Incorrect Phone Number");
    }

    public PhoneNumberException(String message) {
        super(message);
    }

    public PhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneNumberException(Throwable cause) {
        super(cause);
    }

    public PhoneNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
