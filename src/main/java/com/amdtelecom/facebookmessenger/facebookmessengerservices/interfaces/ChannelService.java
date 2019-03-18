package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;

import java.util.List;
import java.util.Map;

public interface ChannelService {
    MessengerServiceChannel createChannel(String channelName, Map<String,String> credentials,String principalId);

    List<MessengerServiceChannel> getAllChannelsOfPrincipal(String principalId);
}
