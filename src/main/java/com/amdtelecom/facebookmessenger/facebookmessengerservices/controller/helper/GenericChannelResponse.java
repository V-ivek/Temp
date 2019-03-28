package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GenericChannelResponse {
		
	private String channelId;
	private String channelName;
    private String appId;
    private String appSecret;
    private String pageId;
    private String pageAccessToken;
    private String verifyToken;
    private String callbackStatusUrl;
    private String callbackInboundUrl;
    @DateTimeFormat(pattern="YYYY-MM-DD'T'HH:mm:ss.SSSZ")
	private Date createdAt;
    @DateTimeFormat(pattern="YYYY-MM-DD'T'HH:mm:ss.SSSZ")
	private Date updatedAt;
	
    public GenericChannelResponse() {	
    }

	public GenericChannelResponse(String channelId, String channelName, String appId, String appSecret, String pageId,
			String pageAccessToken, String verifyToken, String callbackStatusUrl, String callbackInboundUrl,
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

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
