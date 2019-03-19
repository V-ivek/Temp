package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChannelRepository extends MongoRepository<MessengerServiceChannel,String> {

    public List<MessengerServiceChannel> getMessengerServiceChannelsByPrincipalId(String principalId);
//    public MessengerServiceChannel getMessengerServiceChannelByChannelIdAnd(String channelId,String principalId);
}
