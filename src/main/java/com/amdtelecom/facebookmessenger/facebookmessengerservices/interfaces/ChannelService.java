package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;

import java.util.List;
import java.util.Map;

public interface ChannelService {
    ChannelResponse createChannel(Channel channel, String principalId);

    List<Channel> getAllChannelsOfPrincipal(String principalId);
}
