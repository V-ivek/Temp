package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "channels")

public class MessengerServiceChannel extends Channel {
    @Indexed(unique  = true)
    private String channelId;
    private String principalId;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;


    public MessengerServiceChannel(String channelName, Credentials credentials) {
        super(channelName, credentials);
    }

    public MessengerServiceChannel(String channelName, Credentials credentials, String channelId, String principalId, Date createdAt, Date updatedAt, boolean isDeleted) {
        super(channelName, credentials);
        this.channelId = channelId;
        this.principalId = principalId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "MessengerServiceChannel{" +
                "channelId='" + channelId + '\'' +
                ", principalId='" + principalId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
