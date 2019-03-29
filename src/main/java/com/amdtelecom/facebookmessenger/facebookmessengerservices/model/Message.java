package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import org.springframework.data.annotation.PersistenceConstructor;

import java.util.List;
import java.util.Map;

public class Message {
    private Attachment attachments;
    private String text;
    private List<Button> buttons;
    private List<QuickReply> quickReplies;

    public Message(Attachment attachments, String text, List<Button> buttons, List<QuickReply> quickReplies) {
        this.attachments = attachments;
        this.text = text;
        this.buttons = buttons;
        this.quickReplies = quickReplies;
    }

    public Message() {
    }

    @PersistenceConstructor
    public Message(String text){
        this.text=text;
    }

    @Override
    public String toString() {
//        return "MessageBody{" +
//                "attachments=" + attachments +
//                ", text='" + text + '\'' +
//                ", buttons=" + buttons +
//                ", quickReplies=" + quickReplies +
//                '}';
        return "\"text\":\""+this.getText()+"\"";
    }

    public void setAttachments(Attachment attachments) {
        this.attachments = attachments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public List<QuickReply> getQuickReplies() {
        return quickReplies;
    }

    public void setQuickReplies(List<QuickReply> quickReplies) {
        this.quickReplies = quickReplies;
    }
}
