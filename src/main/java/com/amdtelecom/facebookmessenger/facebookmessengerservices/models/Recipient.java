package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipients")
public class Recipient {
    @Indexed
    private String facebookPsid;
    private String firstname;
    private String lastname;
    private String imageUrl;
    private String channelId;
    private String principalId;

    public Recipient() {
    }

    public Recipient(String facebookPsid, String firstname, String lastname, String imageUrl, String channelId, String principalId) {
        this.facebookPsid = facebookPsid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.imageUrl = imageUrl;
        this.channelId = channelId;
        this.principalId = principalId;
    }
    public Recipient(String facebookPsid, String channelId,String principalId){
        this.facebookPsid = facebookPsid;
        this.channelId = channelId;
        this.principalId = principalId;
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "facebookPsid='" + facebookPsid + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", channelId='" + channelId + '\'' +
                ", channelId='" + principalId + '\'' +
                '}';
    }

    public String getFacebookPsid() {
        return facebookPsid;
    }

    public void setFacebookPsid(String facebookPsid) {
        this.facebookPsid = facebookPsid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
