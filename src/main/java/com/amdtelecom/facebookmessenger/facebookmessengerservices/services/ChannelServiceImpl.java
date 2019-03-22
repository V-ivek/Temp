package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.DAL.ChannelDAL;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.*;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.ChannelRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.RecipientRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    RecipientRepository recipientRepository;

    @Override
    public ChannelResponse createChannel(Channel channel, String principalId) {
        String channelId = Utility.generateUuid();
        MessengerServiceChannel messengerServiceChannel = new MessengerServiceChannel(channel.getChannelName(),channel.getCredentials(),channelId,principalId,new Date(),new Date());
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
    public boolean deleteChannel(String principalId,String channelId){
        if(validateChannelAndPrincipal(principalId,channelId)) {
            channelRepository.deleteMessengerServiceChannelByChannelIdAndPrincipalId(channelId,principalId);
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public ChannelResponse updateChannel(String channelId,String principalId, Channel channel) {
        if(channelDAL.update(channelId,principalId,channel)) {
            ChannelResponse channelResponse = channelRepository.getMessengerServiceChannelByPrincipalIdAndChannelId(principalId,channelId);
            return channelResponse;
        }
//        channelDAL.update(channelId,principalId,credentials);
        return null;
    }
    @Override
    public Recipient putUser(String channelId, String principalId, String facebookPsid) {
        Recipient recipient = new Recipient(facebookPsid,channelId,principalId);
        Recipient response = recipientRepository.save(recipient);
        return response;

    }
    public boolean validateChannelAndPrincipal(String principalId,String channelId) {
        if(channelRepository.getMessengerServiceChannelByPrincipalIdAndChannelId(principalId,channelId) != null) {
            return true;
        }
        return false;
    }
}
