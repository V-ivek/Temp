package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import java.util.List;

public class FacebookCredentials {
    private String appId;
    private String appSecret;
    private String pageId;
    private String pageAccessToken;
    private String verifyToken;
    private String callbackStatusUrl;
    private String callbackInboundUrl;

    public FacebookCredentials(String appId, String appSecret, String pageId, String pageAccessToken, String verifyToken, String callbackStatusUrl, String callbackInboundUrl) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.pageId = pageId;
        this.pageAccessToken = pageAccessToken;
        this.verifyToken = verifyToken;
        this.callbackStatusUrl = callbackStatusUrl;
        this.callbackInboundUrl = callbackInboundUrl;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getPageId() {
        return pageId;
    }

    public String getPageAccessToken() {
        return pageAccessToken;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public String getCallbackStatusUrl() {
        return callbackStatusUrl;
    }

    public String getCallbackInboundUrl() {
        return callbackInboundUrl;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public void setPageAccessToken(String pageAccessToken) {
        this.pageAccessToken = pageAccessToken;
    }

    public void setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
    }

    public void setCallbackStatusUrl(String callbackStatusUrl) {
        this.callbackStatusUrl = callbackStatusUrl;
    }

    public void setCallbackInboundUrl(String callbackInboundUrl) {
        this.callbackInboundUrl = callbackInboundUrl;
    }
}
