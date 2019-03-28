package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

public class SendMessageResponse {
    private String messageId;
    private String to;
    private String createdAt;

    public SendMessageResponse(String messageId, String to, String createdAt) {
        this.messageId = messageId;
        this.to = to;
        this.createdAt = createdAt;
    }

    public SendMessageResponse() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
