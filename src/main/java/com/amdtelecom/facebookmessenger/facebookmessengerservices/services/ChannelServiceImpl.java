package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.ChannelRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    ChannelRepository channelRepository;

    @Override
    public ChannelResponse createChannel(Channel channel, String principalId) {
        String channelId = Utility.generateUuid();
        MessengerServiceChannel messengerServiceChannel = new MessengerServiceChannel(channel.getChannelName(),channel.getCredentials(),channelId,principalId,new Date(),new Date(),false);
        MessengerServiceChannel channelResponse = channelRepository.save(messengerServiceChannel);
        ChannelResponse response = new ChannelResponse(channelResponse.getChannelName(),channelResponse.getCredentials(),messengerServiceChannel.getChannelId());
        return response;
    }

    @Override
    public List<Channel> getAllChannelsOfPrincipal(String principalId) {
        List<MessengerServiceChannel> channels = channelRepository.getMessengerServiceChannelsByPrincipalId(principalId);
//        List<Channel> response = channels;
        return null;
    }
}
