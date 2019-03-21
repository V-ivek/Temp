package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

public class CredentialsBase {
    private String pageAccessToken;
    private String verifyToken;
    private String callbackStatusUrl;
    private String callbackInboundUrl;

    public String getPageAccessToken() {
        return pageAccessToken;
    }

    public void setPageAccessToken(String pageAccessToken) {
        this.pageAccessToken = pageAccessToken;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public void setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
    }

    public String getCallbackStatusUrl() {
        return callbackStatusUrl;
    }

    public void setCallbackStatusUrl(String callbackStatusUrl) {
        this.callbackStatusUrl = callbackStatusUrl;
    }

    public String getCallbackInboundUrl() {
        return callbackInboundUrl;
    }

    public void setCallbackInboundUrl(String callbackInboundUrl) {
        this.callbackInboundUrl = callbackInboundUrl;
    }

    public CredentialsBase(String pageAccessToken, String verifyToken, String callbackStatusUrl, String callbackInboundUrl) {
        this.pageAccessToken = pageAccessToken;
        this.verifyToken = verifyToken;
        this.callbackStatusUrl = callbackStatusUrl;
        this.callbackInboundUrl = callbackInboundUrl;
    }

    @Override
    public String toString() {
        return "CredentialsBase{" +
                "pageAccessToken='" + pageAccessToken + '\'' +
                ", verifyToken='" + verifyToken + '\'' +
                ", callbackStatusUrl='" + callbackStatusUrl + '\'' +
                ", callbackInboundUrl='" + callbackInboundUrl + '\'' +
                '}';
    }
}
