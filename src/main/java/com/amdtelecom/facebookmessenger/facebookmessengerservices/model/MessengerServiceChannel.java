package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fbchannels")
@CompoundIndexes({
	@CompoundIndex(name="principalIdANDchannelId", 
		def="{'principalId':1, 'channelId':1}"),
	@CompoundIndex(name="principalIdANDchannelName", 
		def="{'principalId':1, 'channelName':1}", unique=true)
})
public class MessengerServiceChannel {
	
	@Id
	public String id;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String principalId;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String channelId;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String channelName;
    private String appId;
    private String appSecret;
    private String pageId;
    private String pageAccessToken;
    private String verifyToken;
    private String callbackStatusUrl;
    private String callbackInboundUrl;
	@Indexed(direction=IndexDirection.ASCENDING)
    private Long createdAt;
	@Indexed(direction=IndexDirection.ASCENDING)
    private Long updatedAt;
	

    public MessengerServiceChannel() {
    }
    
	public MessengerServiceChannel(String principalId, String channelId, String channelName, 
			String appId, String appSecret, String pageId, String pageAccessToken,
			String verifyToken, String callbackStatusUrl, String callbackInboundUrl, 
			Long createdAt, Long updatedAt) {
		this.principalId = principalId;
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
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(String principalId) {
		this.principalId = principalId;
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

	public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
