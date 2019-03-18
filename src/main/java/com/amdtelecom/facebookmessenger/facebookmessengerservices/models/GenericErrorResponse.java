package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

public class GenericErrorResponse {
    private String error;

    public String getError() {
        return error;
    }

    public GenericErrorResponse(String error) {
        this.error = error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
