package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdateChannelResponse {
		
	private String channelName;
    private String appId;
    private String appSecret;
    private Integer pageId;
    private String pageAccessToken;
    private String verifyToken;
    private String callbackStatusUrl;
    private String callbackInboundUrl;
    @DateTimeFormat(pattern="YYYY-MM-DD'T'HH:mm:ss.SSSZ")
	private Date updatedAt;
	
    public UpdateChannelResponse() {	
    }

	public UpdateChannelResponse(String channelName, String appId, String appSecret, 
			Integer pageId,	String pageAccessToken, String verifyToken, String callbackStatusUrl, 
			String callbackInboundUrl,	Date updatedAt) {
		this.channelName = channelName;
		this.appId = appId;
		this.appSecret = appSecret;
		this.pageId = pageId;
		this.pageAccessToken = pageAccessToken;
		this.verifyToken = verifyToken;
		this.callbackStatusUrl = callbackStatusUrl;
		this.callbackInboundUrl = callbackInboundUrl;
		this.updatedAt = updatedAt;
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

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
