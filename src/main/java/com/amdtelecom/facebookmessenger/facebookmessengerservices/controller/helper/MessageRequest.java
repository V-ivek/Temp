package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Message;

public class MessageRequest {
    private String channelId;
    private String to;
    private Message message;
    private String tag;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "channelId='" + channelId + '\'' +
                ", to='" + to + '\'' +
                ", message=" + message +
                ", tag='" + tag + '\'' +
                '}';
    }

    public MessageRequest() {
    }

    public MessageRequest(String channelId, String to, Message message, String tag) {
        this.channelId = channelId;
        this.to = to;
        this.message = message;
        this.tag = tag;
    }
}
