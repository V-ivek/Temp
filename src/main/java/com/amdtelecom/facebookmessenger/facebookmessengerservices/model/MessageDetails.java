package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fbmessages")

public class MessageDetails {
    private Message message;
    private String to;
    private String flag;
    private String messageId;
    private String channelId;
    private String channelName;
    @Indexed(direction= IndexDirection.ASCENDING)
    private Long createdAt;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MessageDetails{" +
                "message=" + message +
                ", to='" + to + '\'' +
                ", flag='" + flag + '\'' +
                ", messageId='" + messageId + '\'' +
                ", channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public MessageDetails() {
    }

    public MessageDetails(Message message, String to, String flag, String messageId, String channelId, String channelName, Long createdAt) {
        this.message = message;
        this.to = to;
        this.flag = flag;
        this.messageId = messageId;
        this.channelId = channelId;
        this.channelName = channelName;
        this.createdAt = createdAt;
    }
}
