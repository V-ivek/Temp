package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


public class ChannelResponse extends Channel {

    private String channelId;

    public ChannelResponse(String channelName, Credentials credentials, String channelId) {
        super(channelName, credentials);
        this.channelId = channelId;
    }
    public ChannelResponse(){}

    @Override
    public String toString() {
        return "ChannelResponse{" +
                "channelId='" + channelId + '\'' +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
