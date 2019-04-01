package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

public class GraphSendRequestBody {
    private String messaging_type;
    private GraphRecipient recipient;
    private Message message;
    private String tag;

    public GraphSendRequestBody() {
    }

    public GraphSendRequestBody(String messaging_type, GraphRecipient recipient, Message message, String tag) {
        this.messaging_type = messaging_type;
        this.recipient = recipient;
        this.message = message;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "GraphSendRequestBody{" +
                "messaging_type='" + messaging_type + '\'' +
                ", recipient=" + recipient +
                ", message=" + message +
                ", tag='" + tag + '\'' +
                '}';
    }

    public String getMessaging_type() {
        return messaging_type;
    }

    public void setMessaging_type(String messaging_type) {
        this.messaging_type = messaging_type;
    }

    public GraphRecipient getRecipient() {
        return recipient;
    }

    public void setRecipient(GraphRecipient recipient) {
        this.recipient = recipient;
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
}
