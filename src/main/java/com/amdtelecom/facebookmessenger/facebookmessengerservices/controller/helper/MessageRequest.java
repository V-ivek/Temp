package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Message;

public class MessageRequest {
    private String channelId;
    private String to;
    private Message message;

    public MessageRequest() {
    }

    public MessageRequest(String channelId, String to, Message message) {
        this.channelId = channelId;
        this.to = to;
        this.message = message;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "channelId='" + channelId + '\'' +
                ", to='" + to + '\'' +
                ", messageBody=" + message +
                '}';
    }
}
