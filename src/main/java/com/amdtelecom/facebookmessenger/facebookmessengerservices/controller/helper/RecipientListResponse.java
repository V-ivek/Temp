package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class RecipientListResponse {

    public static class Token {
        private String facebookPsid;
        @DateTimeFormat(pattern="YYYY-MM-DD'T'HH:mm:ss.SSSZ")
        private Date updatedAt;

        public Token(String facebookPsid, Date updatedAt) {
            this.facebookPsid = facebookPsid;
            this.updatedAt = updatedAt;
        }

        public String getFacebookPsid() {
            return facebookPsid;
        }

        public void setFacebookPsid(String facebookPsid) {
            this.facebookPsid = facebookPsid;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

    private String channelId;
    private List<Token> facebookUsers;

    public RecipientListResponse() {}

    public RecipientListResponse(List<Token> facebookUsers, String channelId) {
        this.facebookUsers = facebookUsers;
        this.channelId = channelId;
    }

    public String getChanneld() {
        return channelId;
    }

    public void setChanneld(String channeld) {
        this.channelId = channeld;
    }

    public List<Token> getFacebookUsers() {
        return facebookUsers;
    }

    public void setPsids(List<Token> facebookUsers) {
        this.facebookUsers = facebookUsers;
    }

}