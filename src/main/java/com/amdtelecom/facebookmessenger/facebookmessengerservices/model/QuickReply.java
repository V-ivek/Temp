package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

public class QuickReply {
    private String quickReplyType;
    private String quickReplyValue;
    public String getQuickReplyType() {
        return quickReplyType;
    }
    public void setQuickReplyType(String quickReplyType) {
        this.quickReplyType = quickReplyType;
    }
    public String getQuickReplyValue() {
        return quickReplyValue;
    }
    public void setQuickReplyValue(String quickReplyValue) {
        this.quickReplyValue = quickReplyValue;
    }
    public QuickReply(String quickReplyType, String quickReplyValue) {
        super();
        this.quickReplyType = quickReplyType;
        this.quickReplyValue = quickReplyValue;
    }
    public QuickReply() {
        super();
    }
}
