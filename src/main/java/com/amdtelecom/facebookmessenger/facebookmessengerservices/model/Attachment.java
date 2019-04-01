package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

public class Attachment {
    private String type;
    private Payload payload;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Attachment() {
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "type='" + type + '\'' +
                ", payload=" + payload +
                '}';
    }

    public Attachment(String type, Payload payload) {
        this.type = type;
        this.payload = payload;
    }
}
