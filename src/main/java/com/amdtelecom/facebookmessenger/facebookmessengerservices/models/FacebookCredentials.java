package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import java.util.List;

public class FacebookCredentials {
    private String appId;
    private String appSecret;
    private String pageId;
    private String pageAccessToken;
    private String verifyToken;
    private String callbackUrl;

    public FacebookCredentials(String appId, String appSecret, String pageId, String pageAccessToken, String verifyToken, String callbackUrl) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.pageId = pageId;
        this.pageAccessToken = pageAccessToken;
        this.verifyToken = verifyToken;
        this.callbackUrl = callbackUrl;
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

    @Override
    public String toString() {
        return "FacebookCredentials{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", pageId='" + pageId + '\'' +
                ", pageAccessToken='" + pageAccessToken + '\'' +
                ", verifyToken='" + verifyToken + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public void setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
