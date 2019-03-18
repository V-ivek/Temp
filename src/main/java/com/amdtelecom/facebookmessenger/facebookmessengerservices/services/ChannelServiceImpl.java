package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
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
    public MessengerServiceChannel createChannel(String channelName, Map<String,String> credentials,String principalId) {
        String channelId = Utility.generateUuid();
        MessengerServiceChannel channel = new MessengerServiceChannel(channelId,channelName,
                credentials.get("appId"),credentials.get("appSecret"),
                credentials.get("pageId"),credentials.get("pageAccessToken"),
                credentials.get("verifyToken"),credentials.get("callbackStatusUrl"),
                credentials.get("callbackInboundUrl"),principalId,new Date(),new Date());
        System.out.println("Reached here2" + channel);
        channelRepository.save(channel);
        return channel;
    }

    @Override
    public List<MessengerServiceChannel> getAllChannelsOfPrincipal(String principalId) {
        List<MessengerServiceChannel> channels = channelRepository.getMessengerServiceChannelsByPrincipalId(principalId);
        return channels;
    }
}
