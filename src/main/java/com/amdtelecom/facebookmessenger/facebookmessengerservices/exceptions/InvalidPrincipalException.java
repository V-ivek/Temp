package com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions;

public class InvalidPrincipalException extends Exception{
    private String errorMessage;

    public InvalidPrincipalException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}