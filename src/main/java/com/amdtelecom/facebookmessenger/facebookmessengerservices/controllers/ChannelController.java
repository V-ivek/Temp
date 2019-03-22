package com.amdtelecom.facebookmessenger.facebookmessengerservices.controllers;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.*;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        return channels;
    }
    @GetMapping(value = "/facebook/channel/{channelId}", produces = "application/json")
    public ChannelResponse getFacebookChannel(@RequestHeader("principalId") String principalId,@PathVariable("channelId") String channelId){
        ChannelResponse channel = channelService.getChannel(principalId,channelId);
        return channel;
    }
    @DeleteMapping(value = "facebook/channel/{channelId}", produces = "application/json")
    public ResponseEntity deleteChannel(@RequestHeader("principalId") String principalId,@PathVariable("channelId") String channelId) {
        boolean resp = channelService.deleteChannel(principalId,channelId);
        if(resp) {
            JSONObject response = new JSONObject();
            response.put("status","success");
            response.put("message","The channel with channel Id channelId is deleted successfully");
            return new ResponseEntity(response.toString(), HttpStatus.OK);
        }
        JSONObject response = new JSONObject();
        response.put("error","Invalid combination of principalId and channelId");
        return new ResponseEntity(response.toString(),HttpStatus.BAD_REQUEST);

    }
    @PostMapping(value = "/facebook/channel/{channelId}", produces = "application/json")
    public  ChannelResponse updateChannel(@RequestHeader("principalId") String principalId,@PathVariable("channelId") String channelId,@RequestBody Credentials credentials) {
        ChannelResponse channelResponse = channelService.updateChannel(channelId,principalId,credentials);
        return channelResponse;
    }
    @PostMapping(value = "/facebook/channel/{channelId}/recipient" , produces = "application/json")
    public ResponseEntity putUser(@RequestHeader("principalId") String principalId,@PathVariable("channelId") String channelId,@RequestBody Recipient facebookPsid){
        Recipient recipient = channelService.putUser(channelId,principalId, facebookPsid.getFacebookPsid());
        JSONObject response = new JSONObject();
        response.put("channelId",recipient.getChannelId());
        response.put("facebookPsid",recipient.getFacebookPsid());
        return new ResponseEntity(response.toString(),HttpStatus.OK);
    }
//    @GetMapping(value = "facebook/channel/{channelId}" , produces = 'application/json")')
//    public List<Recipient> getUsers(@RequestHeader("principalId") String principalId,@PathVariable("channleId") String channelId) {
//        List<Recipient> recipients = recipientSer
//    }
}
