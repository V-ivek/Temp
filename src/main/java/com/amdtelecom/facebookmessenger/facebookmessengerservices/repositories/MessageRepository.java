package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessageDetails;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessageDetailsList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<MessageDetails, String> {

    MessageDetails getMessageDetailsByMessageId(String messageId);
    List<MessageDetailsList> getAllByChannelIdAndAndTo(String channelId, String to);
}
