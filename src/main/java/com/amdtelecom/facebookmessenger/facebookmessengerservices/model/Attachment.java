package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

public class Attachment {
    private String attachmentType;
    private String mediaUrl;
    private String action;

    public Attachment(String attachmentType, String mediaUrl, String action) {
        this.attachmentType = attachmentType;
        this.mediaUrl = mediaUrl;
        this.action = action;
    }

    public Attachment() {
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachmentType='" + attachmentType + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", action='" + action + '\'' +
                '}';
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
