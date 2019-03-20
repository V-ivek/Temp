package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.DAL.ChannelDAL;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.ChannelRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    ChannelDAL channelDAL;

    @Override
    public ChannelResponse createChannel(Channel channel, String principalId) {
        String channelId = Utility.generateUuid();
        MessengerServiceChannel messengerServiceChannel = new MessengerServiceChannel(channel.getChannelName(),channel.getCredentials(),channelId,principalId,new Date(),new Date(),false);
        MessengerServiceChannel channelResponse = channelRepository.save(messengerServiceChannel);
        ChannelResponse response = new ChannelResponse(channelResponse.getChannelName(),channelResponse.getCredentials(),messengerServiceChannel.getChannelId());
        return response;
    }

    @Override
    public List<ChannelResponse> getAllChannelsOfPrincipal(String principalId) {
        List<ChannelResponse> channels = channelDAL.getAllFacebookChannelsOfPrincipal(principalId);
        return channels;
    }
    @Override
    public ChannelResponse getChannel(String principalId,String channelId) {
        ChannelResponse channel = channelRepository.getMessengerServiceChannelByPrincipalIdAndChannelId(principalId,channelId);
        return channel;
    }
    @Override
    public void deleteChannel(String principalId,String channelId){
        System.out.println("This is" + channelId);
//        channelRepository.deleteById(channelId);
        channelDAL.delete(channelId,principalId);
        System.out.println("This is");
    }
}
