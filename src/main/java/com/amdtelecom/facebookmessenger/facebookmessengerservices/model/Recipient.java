package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;


import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipients")
@CompoundIndexes(
        @CompoundIndex(name = "principalIdANDchannelId", def = "{'principalId':1,'channelId':1}")
)
public class Recipient {

    @Indexed(direction=IndexDirection.ASCENDING)
    private String principalId;
    @Indexed(direction=IndexDirection.ASCENDING)
    private String channelId;
    private String facebookPsid;
    @Indexed(direction=IndexDirection.ASCENDING)
    private Long createdAt;
    @Indexed(direction=IndexDirection.ASCENDING)
    private Long updatedAt;

    public Recipient() {
    }

    public Recipient(String principalId, String channelId, String facebookPsid, Long createdAt, Long updatedAt) {
        this.principalId = principalId;
        this.channelId = channelId;
        this.facebookPsid = facebookPsid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getFacebookPsid() {
        return facebookPsid;
    }

    public void setFacebookPsid(String facebookPsid) {
        this.facebookPsid = facebookPsid;
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
