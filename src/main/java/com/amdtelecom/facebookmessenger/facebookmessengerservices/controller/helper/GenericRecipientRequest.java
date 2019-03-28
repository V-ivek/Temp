package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

public class GenericRecipientRequest {

    private String facebookPsid;

    public GenericRecipientRequest(String facebookPsid) {
        this.facebookPsid = facebookPsid;
    }

    public GenericRecipientRequest() {
    }

    public String getFacebookPsid() {
        return facebookPsid;
    }

    public void setFacebookPsid(String facebookPsid) {
        this.facebookPsid = facebookPsid;
    }
}
