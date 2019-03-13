package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "principals")
public class MessengerServicePrincipal {
    @Indexed(unique = true)
    private String principalId;
    private String platformId;
    private Map<String,String> metadata;
    private List<MessengerServiceChannel> messengerServiceChannels;
    private Date createdAt;
    private Date updatedAt;

    public MessengerServicePrincipal(String principalId, String platformId, Map<String, String> metadata, List<MessengerServiceChannel> messengerServiceChannels, Date createdAt, Date updatedAt) {
        this.principalId = principalId;
        this.platformId = platformId;
        this.metadata = metadata;
        this.messengerServiceChannels = messengerServiceChannels;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public List<MessengerServiceChannel> getMessengerServiceChannels() {
        return messengerServiceChannels;
    }

    public void setMessengerServiceChannels(List<MessengerServiceChannel> messengerServiceChannels) {
        this.messengerServiceChannels = messengerServiceChannels;
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

    @Override
    public String toString() {
        return "MessengerServicePrincipal{" +
                "principalId='" + principalId + '\'' +
                ", platformId='" + platformId + '\'' +
                ", metadata=" + metadata +
                ", messengerServiceChannels=" + messengerServiceChannels +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}