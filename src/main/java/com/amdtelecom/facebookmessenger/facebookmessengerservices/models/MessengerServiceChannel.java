package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import java.util.Date;
import java.util.List;

public class MessengerServiceChannel {
    private String channelName;
    private String channelId;
    private FacebookCredentials facebookCredentials;
    private List<String> facebookPsids;
    private Date createdAt;
    private Date updatedAt;

    public MessengerServiceChannel(String channelName, String channelId, FacebookCredentials facebookCredentials, List<String> facebookPsids, Date createdAt, Date updatedAt) {
        this.channelName = channelName;
        this.channelId = channelId;
        this.facebookCredentials = facebookCredentials;
        this.facebookPsids = facebookPsids;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public FacebookCredentials getFacebookCredentials() {
        return facebookCredentials;
    }

    public void setFacebookCredentials(FacebookCredentials facebookCredentials) {
        this.facebookCredentials = facebookCredentials;
    }

    public List<String> getFacebookPsids() {
        return facebookPsids;
    }

    public void setFacebookPsids(List<String> facebookPsids) {
        this.facebookPsids = facebookPsids;
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
