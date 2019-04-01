package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.SendMessageResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.MessageService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessageDetails;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessageDetailsList;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;
    @PostMapping(path = "/facebook/message")
    public SendMessageResponse sendMessage(@RequestHeader String principalId, @RequestBody MessageRequest messageRequest)throws Exception{
        System.out.println(messageRequest);
        messageService.sendMessage(principalId,messageRequest);
//        String command = "curl -i -X POST https://graph.facebook.com/v3.2/me/messages?recipient=%7B%22id%22%3A%222345081478864905%22%7D&message=%7B%22text%22%3A%20%22hello%2C%20world!%22%7D&message_type=MESSAGE_TAG&tag=COMMUNITY_ALERT&access_token=EAAFt8wkZA258BAIbOS11l1AYwsd1O6kZC4bZCe0cLTaMpLSNil9lWwyXDTqQdNcrTCAIpGWPBsGnrXNVJZCZBSIZBQLnAuvVfSedPDKPiC3tFIruRz2luuiI4w9aGn0n4EDhBq7tRZBTZCd6qXcZCYitYUno7t7NA2ye8IAZCvgZAGAe5UxOZC2ZAigavz2ifmrVNZB2AZD";
//        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
//        processBuilder.directory(new File("/home/"));
//        Process process = processBuilder.start();
//        InputStream inputStream = process.getInputStream();
//        System.out.println(inputStream);
        return null;
    }
    @GetMapping(path = "facebook/message/{messageId}")
    public MessageDetails getDetailsOfMessage(@RequestHeader String principalId,@PathVariable String messageId){
        return messageService.getMessageDetails(messageId);
    }
    @GetMapping(path = "facebook/message/{channelId}/{psid}")
    public List<MessageDetailsList> getAllMessages(@RequestHeader String principalId, @PathVariable String channelId, @PathVariable String psid) {
        return messageService.getAllMessages(channelId,psid);

    }

}
