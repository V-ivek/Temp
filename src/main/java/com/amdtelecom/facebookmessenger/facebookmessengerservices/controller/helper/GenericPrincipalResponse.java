package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

public class GenericPrincipalResponse {
    private String principalId;
    private Map<String, Object> metadata = null;
    @DateTimeFormat(pattern="YYYY-MM-DD'T'HH:mm:ss.SSSZ")
    private Date createdAt;

    protected GenericPrincipalResponse() {
    	this.createdAt = new Date();
    }
    
    public GenericPrincipalResponse(String principalId, Map<String, Object> metadata, Long milliseconds) {
        this.principalId = principalId;
        this.metadata = metadata;
        this.createdAt = new Date(milliseconds);
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MessengerServicePrincipal{" +
                "principalId='" + principalId + '\'' +
                ", metadata=" + metadata +
                ", createdAt=" + createdAt +
                '}';
    }
	

}
