package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

public class ChannelUpdateRequest {

	private String channelName;
	private String pageAccessToken;
	private String verifyToken;
	private String callbackStatusUrl;
	private String callbackInboundUrl;
	
	public ChannelUpdateRequest() {
		
	}
	
	public ChannelUpdateRequest(String channelName,
			String appId, String appSecret, Integer pageId,	String pageAccessToken, 
			String verifyToken, String callbackStatusUrl,
			String callbackInboundUrl) {
		this.channelName = channelName;
		this.pageAccessToken = pageAccessToken;
		this.verifyToken = verifyToken;
		this.callbackInboundUrl = callbackInboundUrl;
		this.callbackStatusUrl = callbackStatusUrl;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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
