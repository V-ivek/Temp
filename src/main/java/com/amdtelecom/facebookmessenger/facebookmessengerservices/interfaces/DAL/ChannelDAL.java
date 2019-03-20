package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.DAL;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Credentials;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;

import java.util.List;

public interface ChannelDAL {

    List<ChannelResponse> getAllFacebookChannelsOfPrincipal(String principalId);

    void delete(String channelId, String principalId);

    ChannelResponse update(String channelId, Credentials credentials);
}
