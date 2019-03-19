package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

public class ChannelResponse extends Channel {

    private  String channelId;

    public ChannelResponse(String channelName, Credentials credentials, String channelId) {
        super(channelName, credentials);
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ChannelResponse{" +
                "channelId='" + channelId + '\'' +
                '}';
    }

    public ChannelResponse(String channelName, Credentials credentials) {
        super(channelName, credentials);
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
