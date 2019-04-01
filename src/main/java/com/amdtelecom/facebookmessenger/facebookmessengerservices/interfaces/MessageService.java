package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Message;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessageDetails;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessageDetailsList;

import java.util.List;

public interface MessageService {
    void sendMessage(String principalId, MessageRequest messageRequest) throws Exception;

    MessageDetails getMessageDetails(String messageId);

    List<MessageDetailsList> getAllMessages(String channelId, String to);
}
