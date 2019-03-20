package com.amdtelecom.facebookmessenger.facebookmessengerservices.controllers;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Credentials;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<ChannelResponse> getAllChannelsOfPrincipal(@RequestHeader("principalId") String principalId) {
        List<ChannelResponse> channels = channelService.getAllChannelsOfPrincipal(principalId);
        System.out.println("This is---" + channels );
        return channels;
    }
    @GetMapping(value = "/facebook/channel/{channelId}", produces = "application/json")
    public ChannelResponse getFacebookChannel(@RequestHeader("principalId") String principalId,@PathVariable("channelId") String channelId){
        ChannelResponse channel = channelService.getChannel(principalId,channelId);
        System.out.println(channel);
        return channel;
    }
    @DeleteMapping(value = "facebook/channel/{channelId}", produces = "application/json")
    public ResponseEntity deleteChannel(@RequestHeader("principalId") String principalId,@PathVariable("channelId") String channelId) {
        channelService.deleteChannel(principalId,channelId);
        JSONObject response = new JSONObject();
        response.put("status","success");
        response.put("message","The channel with channel Id channelId is deleted successfully");
        return new ResponseEntity(response.toString(), HttpStatus.OK);
    }
    @PutMapping(value = "/facebook/channel/{channelId}", produces = "application/json")
    public  ChannelResponse updateChannel(@RequestHeader("principalId") String principalId,@PathVariable("channelId") String channelId,@RequestBody Credentials credentials) {
        System.out.println(credentials);
        return null;
    } {

    }
//    @PutMapping(value = "facebook/channel/{channelId}" , produces = "application/json")
//    public ResponseEntity updateChannel()
}
