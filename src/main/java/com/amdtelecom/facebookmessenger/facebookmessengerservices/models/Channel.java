package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Channel {
    private String channelName;
    private Credentials credentials;

    public Channel(String channelName, Credentials credentials) {
        this.channelName = channelName;
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelName='" + channelName + '\'' +
                ", credentials=" + credentials +
                '}';
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials() {
        setCredentials();
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
