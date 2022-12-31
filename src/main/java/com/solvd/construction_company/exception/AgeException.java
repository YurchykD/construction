package com.solvd.construction_company.exception;

public class AgeException extends Exception{
    public AgeException(){
      super("Incorrect Age");
    }

    public AgeException(String message) {
      super(message);
    }

    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeException(Throwable cause) {
        super(cause);
    }

    public AgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
