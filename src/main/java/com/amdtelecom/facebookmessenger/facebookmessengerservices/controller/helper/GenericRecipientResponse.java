package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GenericRecipientResponse {
    private String facebookPsid;
    private String channeld;
    @DateTimeFormat(pattern="YYYY-MM-DD'T'HH:mm:ss.SSSZ")
    private Date updatedAt;

    public GenericRecipientResponse() {
    }

    public GenericRecipientResponse(String facebookPsid, String channeld, Date updatedAt) {
        this.facebookPsid = facebookPsid;
        this.channeld = channeld;
        this.updatedAt = updatedAt;
    }

    public String getFacebookPsid() {
        return facebookPsid;
    }

    public void setFacebookPsid(String facebookPsid) {
        this.facebookPsid = facebookPsid;
    }

    public String getChanneld() {
        return channeld;
    }

    public void setChanneld(String channeld) {
        this.channeld = channeld;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
