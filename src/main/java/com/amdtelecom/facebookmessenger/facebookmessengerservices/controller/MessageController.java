package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.SendMessageResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @PostMapping(path = "/facebook/message")
    public SendMessageResponse sendMessage(@RequestHeader String principalId, @RequestBody MessageRequest messageRequest){
        System.out.println(messageRequest);
        return null;
    }

}
