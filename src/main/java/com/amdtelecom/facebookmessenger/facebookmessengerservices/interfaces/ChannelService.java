package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ChannelService {
    ChannelResponse createChannel(Channel channel, String principalId);

    List<ChannelResponse> getAllChannelsOfPrincipal(String principalId);

    ChannelResponse getChannel(String principalId,String channelId);

    boolean deleteChannel(String principalId,String channelId);

    ChannelResponse updateChannel(String channelId, String principalId,Credentials credentials);

    Recipient putUser(String channelId, String principalId, String facebookPsid);
}
