package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessageBody;

public class MessageRequest {
    private String channelId;
    private String to;
    private MessageBody messageBody;

    public MessageRequest() {
    }

    public MessageRequest(String channelId, String to, MessageBody messageBody) {
        this.channelId = channelId;
        this.to = to;
        this.messageBody = messageBody;
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

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "channelId='" + channelId + '\'' +
                ", to='" + to + '\'' +
                ", messageBody=" + messageBody +
                '}';
    }
}
