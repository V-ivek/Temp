package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.GraphApiService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.MessageService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.InputStream;

@Service
public class MessageServiceImplementation implements MessageService {
    @Autowired
    ChannelService channelService;

    @Autowired
    GraphApiService graphApiService;

    private static String curlString = "curl -i -X POST https://graph.facebook.com/v3.2/me/messages?";

    @Override
    public void sendMessage(String principalId, MessageRequest messageRequest) throws Exception{
//        String command = "curl -i -X POST https://graph.facebook.com/v3.2/me/messages?recipient=%7B%22id%22%3A%222345081478864905%22%7D&message=%7B%22text%22%3A%20%22hello%2C%20world!%22%7D&message_type=MESSAGE_TAG&tag=COMMUNITY_ALERT&access_token=EAAFt8wkZA258BAIbOS11l1AYwsd1O6kZC4bZCe0cLTaMpLSNil9lWwyXDTqQdNcrTCAIpGWPBsGnrXNVJZCZBSIZBQLnAuvVfSedPDKPiC3tFIruRz2luuiI4w9aGn0n4EDhBq7tRZBTZCd6qXcZCYitYUno7t7NA2ye8IAZCvgZAGAe5UxOZC2ZAigavz2ifmrVNZB2AZD";

        MessengerServiceChannel channel = channelService.getChannelForPrincipal(principalId,messageRequest.getChannelId());
        System.out.println("channel" + channel+"==="+messageRequest.getChannelId());

        graphApiService.sendMessage(messageRequest,channel);
//        String command = curlString.concat("recipient="+messageRequest.getTo()+"&message="+messageRequest.getMessage()+"&message_type=MESSAGE_TAG&tag=COMMUNITY_ALERT&access_token="+channel.getPageAccessToken());
//        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
//        processBuilder.directory(new File("/home/"));
//        Process process = processBuilder.start();
//        InputStream inputStream = process.getInputStream();

    }
}
