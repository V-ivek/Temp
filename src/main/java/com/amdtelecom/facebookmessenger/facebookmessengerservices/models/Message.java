package com.amdtelecom.facebookmessenger.facebookmessengerservices.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {
	@Indexed
	private String messageId;
	private String channelId;
	private MessageBody messagebody;
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
	public MessageBody getMessagebody() {
		return messagebody;
	}
	public void setMessagebody(MessageBody messagebody) {
		this.messagebody = messagebody;
	}
	public Message(String messageId, String channelId, MessageBody messagebody) {
		super();
		this.messageId = messageId;
		this.channelId = channelId;
		this.messagebody = messagebody;
	}
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", channelId=" + channelId + ", messagebody=" + messagebody + "]";
	}
	
	
	
}
