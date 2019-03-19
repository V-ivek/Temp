package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import org.springframework.beans.factory.annotation.Required;

public class Credentials {
    private String appId;
    private String appSecret;
    private String pageId;
    private String pageAccessToken;
    private String verifyToken;
    private String callbackStatusUrl;
    private String callbackInboundUrl;

    public Credentials(String appId, String appSecret, String pageId, String pageAccessToken, String verifyToken, String callbackStatusUrl, String callbackInboundUrl) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.pageId = pageId;
        this.pageAccessToken = pageAccessToken;
        this.verifyToken = verifyToken;
        this.callbackStatusUrl = callbackStatusUrl;
        this.callbackInboundUrl = callbackInboundUrl;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", pageId='" + pageId + '\'' +
                ", pageAccessToken='" + pageAccessToken + '\'' +
                ", verifyToken='" + verifyToken + '\'' +
                ", callbackStatusUrl='" + callbackStatusUrl + '\'' +
                ", callbackInboundUrl='" + callbackInboundUrl + '\'' +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

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
}
