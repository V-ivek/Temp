package com.amdtelecom.facebookmessenger.facebookmessengerservices.controllers;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Credentials;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ChannelController {
    @Autowired
    ChannelService channelService;

    @PostMapping(value = "/facebook/channel", produces="application/json")
    public ChannelResponse createChannel(@RequestHeader("principalId") String principalId, @RequestBody Channel channel){
        ChannelResponse channelResponse = channelService.createChannel(channel,principalId);
        return channelResponse;
    }
    @GetMapping(value = "/facebook/channel", produces = "application/json")
    public List<Channel> getAllChannelsOfPrincipal(@RequestHeader("principalId") String principalId) {

        return null;
    }
}
