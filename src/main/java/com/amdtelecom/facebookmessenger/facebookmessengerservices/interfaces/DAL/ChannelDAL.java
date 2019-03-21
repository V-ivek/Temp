package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.DAL;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Credentials;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ChannelDAL {

    Page<ChannelResponse> getAllFacebookChannelsOfPrincipal(String principalId);

    void delete(String channelId, String principalId);

    ChannelResponse update(String channelId, Credentials credentials);
}
