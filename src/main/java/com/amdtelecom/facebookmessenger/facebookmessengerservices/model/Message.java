package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.List;
import java.util.Map;

public class Message {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Attachment attachment;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String text;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<QuickReply> quick_replies;

    @Override
    public String toString() {
        return "Message{" +
                "attachment=" + attachment +
                ", text='" + text + '\'' +
                ", quick_replies=" + quick_replies +
                '}';
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<QuickReply> getQuick_replies() {
        return quick_replies;
    }

    public void setQuick_replies(List<QuickReply> quick_replies) {
        this.quick_replies = quick_replies;
    }

    public Message() {
    }

    public Message(Attachment attachment, String text, List<QuickReply> quick_replies) {
        this.attachment = attachment;
        this.text = text;
        this.quick_replies = quick_replies;
    }
}
