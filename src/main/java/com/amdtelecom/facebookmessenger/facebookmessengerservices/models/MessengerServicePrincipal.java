package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "principals")
public class MessengerServicePrincipal {
    @Indexed(unique = true)
    private String principalId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String platformId;
    private Map<String,String> metadata;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedAt;


    @PersistenceConstructor
    public MessengerServicePrincipal(String principalId,Map<String,String> metadata){
        this.principalId=principalId;
        this.metadata=metadata;
    }
    public MessengerServicePrincipal() {}

    public MessengerServicePrincipal(String principalId, String platformId, Map<String, String> metadata, Date createdAt, Date updatedAt) {
        this.principalId = principalId;
        this.platformId = platformId;
        this.metadata = metadata;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "MessengerServicePrincipal{" +
                "principalId='" + principalId + '\'' +
                ", platformId='" + platformId + '\'' +
                ", metadata=" + metadata +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
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
