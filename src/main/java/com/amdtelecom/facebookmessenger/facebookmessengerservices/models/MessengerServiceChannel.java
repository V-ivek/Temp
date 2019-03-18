package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "channels")

public class MessengerServiceChannel {
    @Indexed(unique  = true)
    private String channelId;
    private String channelName;
    private String appId;
    private String appSecret;
    private String pageId;
    private String pageAccessToken;
    private String verifyToken;
    private String callbackStatusUrl;
    private String callbackInboundUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String principalId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedAt;

    public MessengerServiceChannel(String channelId, String channelName, String appId,
                                   String appSecret, String pageId, String pageAccessToken,
                                   String verifyToken, String callbackStatusUrl,
                                   String callbackInboundUrl, String principalId,
                                   Date createdAt, Date updatedAt) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.appId = appId;
        this.appSecret = appSecret;
        this.pageId = pageId;
        this.pageAccessToken = pageAccessToken;
        this.verifyToken = verifyToken;
        this.callbackStatusUrl = callbackStatusUrl;
        this.callbackInboundUrl = callbackInboundUrl;
        this.principalId = principalId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
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

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "MessengerServiceChannel{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", pageId='" + pageId + '\'' +
                ", pageAccessToken='" + pageAccessToken + '\'' +
                ", verifyToken='" + verifyToken + '\'' +
                ", callbackStatusUrl='" + callbackStatusUrl + '\'' +
                ", callbackInboundUrl='" + callbackInboundUrl + '\'' +
                ", principalId='" + principalId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
