package com.amdtelecom.facebookmessenger.facebookmessengerservices.model;

import java.util.List;
import java.util.Map;

public class MessageBody {
    private Map<String,String> attachments;
    private String text;
    private List<Button> buttons;
    private List<QuickReply> quickReplies;
    public Map<String, String> getAttachments() {
        return attachments;
    }
    public void setAttachments(Map<String, String> attachments) {
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
    public MessageBody(Map<String, String> attachments, String text, List<Button> buttons,
                       List<QuickReply> quickReplies) {
        super();
        this.attachments = attachments;
        this.text = text;
        this.buttons = buttons;
        this.quickReplies = quickReplies;
    }
    public MessageBody() {
        super();
    }
    @Override
    public String toString() {
        return "MessageBody [attachments=" + attachments + ", text=" + text + ", buttons=" + buttons + ", quickReplies="
                + quickReplies + "]";
    }
}
