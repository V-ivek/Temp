package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Document(collection = "fbprincipals")
public class MessengerServicePrincipal {
	@Id
	private String id;
    @Indexed(unique = true)
    private String principalId;
    private String platformId;
    private Map<String, Object> metadata = null;
    private Long createdAt;

    protected MessengerServicePrincipal() {
    }

    public MessengerServicePrincipal(String platformId, Map<String, Object> metadata) {
        this.principalId = UUID.randomUUID().toString();
        this.platformId = platformId;
        this.metadata = metadata;
        this.createdAt = new Date().getTime();
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

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MessengerServicePrincipal{" +
                "principalId='" + principalId + '\'' +
                ", platformId='" + platformId + '\'' +
                ", metadata=" + metadata +
                ", createdAt=" + createdAt +
                '}';
    }
}
