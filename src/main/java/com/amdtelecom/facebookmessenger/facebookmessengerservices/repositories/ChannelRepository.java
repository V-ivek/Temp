package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChannelRepository extends MongoRepository<MessengerServiceChannel,String> {

    ChannelResponse getMessengerServiceChannelByPrincipalIdAndChannelId(String principalId,String channelId);

}
