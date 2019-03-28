package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.SendMessageResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.InputStream;

@RestController
public class MessageController {

    @PostMapping(path = "/facebook/message")
    public SendMessageResponse sendMessage(@RequestHeader String principalId, @RequestBody MessageRequest messageRequest)throws Exception{
        System.out.println(messageRequest);
        String command = "curl -i -X POST https://graph.facebook.com/v3.2/me/messages?recipient=%7B%22id%22%3A%222345081478864905%22%7D&message=%7B%22text%22%3A%20%22hello%2C%20world!%22%7D&message_type=MESSAGE_TAG&tag=COMMUNITY_ALERT&access_token=EAAFt8wkZA258BAIbOS11l1AYwsd1O6kZC4bZCe0cLTaMpLSNil9lWwyXDTqQdNcrTCAIpGWPBsGnrXNVJZCZBSIZBQLnAuvVfSedPDKPiC3tFIruRz2luuiI4w9aGn0n4EDhBq7tRZBTZCd6qXcZCYitYUno7t7NA2ye8IAZCvgZAGAe5UxOZC2ZAigavz2ifmrVNZB2AZD";
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(new File("/home/"));
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        System.out.println(inputStream);
        return null;
    }

}
