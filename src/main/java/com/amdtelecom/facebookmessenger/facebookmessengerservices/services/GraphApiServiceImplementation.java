package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.GraphApiService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.GraphRecipient;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Message;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
public class GraphApiServiceImplementation implements GraphApiService {
    @Autowired
    RestTemplate restTemplate;

    private static String curlString = "https://graph.facebook.com/v3.2/me/messages";

    @Override
    public void sendMessage(MessageRequest messageRequest, MessengerServiceChannel channel) {

        HttpHeaders headers = new HttpHeaders();


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<MessageRequest> entity = null;

        Message message = new Message();
        message.setText("Hey there");
//        GraphRecipient recipient = new GraphRecipient("2345081478864905");
        Map<String,String> recipient = new HashMap<String, String>();
        recipient.put("id","2345081478864905");
        String test = recipient.toString();
        System.out.println(test);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(curlString)
                // Add query parameter
                .queryParam("access_token", "EAAFt8wkZA258BAIbOS11l1AYwsd1O6kZC4bZCe0cLTaMpLSNil9lWwyXDTqQdNcrTCAIpGWPBsGnrXNVJZCZBSIZBQLnAuvVfSedPDKPiC3tFIruRz2luuiI4w9aGn0n4EDhBq7tRZBTZCd6qXcZCYitYUno7t7NA2ye8IAZCvgZAGAe5UxOZC2ZAigavz2ifmrVNZB2AZD")
                .queryParam("message_type", "MESSAGE_TAG")
                .queryParam("recipient",test)
                .queryParam("message","{'text':'hello'}")
                .queryParam("tag","COMMUNITY_ALERT");
        Map<String, String> uriParams = new HashMap<String, String>();
        uriParams.put("access_token", "EAAFt8wkZA258BAIbOS11l1AYwsd1O6kZC4bZCe0cLTaMpLSNil9lWwyXDTqQdNcrTCAIpGWPBsGnrXNVJZCZBSIZBQLnAuvVfSedPDKPiC3tFIruRz2luuiI4w9aGn0n4EDhBq7tRZBTZCd6qXcZCYitYUno7t7NA2ye8IAZCvgZAGAe5UxOZC2ZAigavz2ifmrVNZB2AZD");
        uriParams.put("id","veruthe");
//        String loc =builder.buildAndExpand().toUri();
        System.out.println(builder.buildAndExpand(uriParams).toUri());

        String response = restTemplate.exchange(
                builder.buildAndExpand(uriParams).toUri(), HttpMethod.POST, entity, String.class).getBody();
    }
}
