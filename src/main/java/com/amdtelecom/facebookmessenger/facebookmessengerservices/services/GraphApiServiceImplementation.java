package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.GraphApiService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.*;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.MessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class GraphApiServiceImplementation implements GraphApiService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    MessageRepository messageRepository;

    private static String curlString = "https://graph.facebook.com/v3.2/me/messages";

    @Override
    public void sendMessage(MessageRequest messageRequest, MessengerServiceChannel channel) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        GraphSendRequestBody data = new GraphSendRequestBody();
        GraphRecipient recipient = new GraphRecipient(messageRequest.getTo());
        data.setMessaging_type("MESSAGE_TAG");
        data.setRecipient(recipient);
        data.setMessage(messageRequest.getMessage());
        data.setTag(messageRequest.getTag());
        String value=null;
        try {
            ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
            value = mapper.writeValueAsString(data);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> entity = new HttpEntity<String>(value,headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(curlString)
//                 Add query parameter
                .queryParam("access_token", "EAAFt8wkZA258BAIbOS11l1AYwsd1O6kZC4bZCe0cLTaMpLSNil9lWwyXDTqQdNcrTCAIpGWPBsGnrXNVJZCZBSIZBQLnAuvVfSedPDKPiC3tFIruRz2luuiI4w9aGn0n4EDhBq7tRZBTZCd6qXcZCYitYUno7t7NA2ye8IAZCvgZAGAe5UxOZC2ZAigavz2ifmrVNZB2AZD");
        String loc =builder.buildAndExpand().toUri().toString();
        JSONObject response = new JSONObject(restTemplate.exchange(
                loc, HttpMethod.POST, entity, String.class));
        JSONObject responseBody = new JSONObject(response.get("body").toString());
        if(response.get("statusCodeValue").toString().equals("200")) {
            MessageDetails messageDetails = new MessageDetails(messageRequest.getMessage(),messageRequest.getTo(),"outbound",
                    responseBody.get("message_id").toString(),channel.getChannelId(),channel.getChannelName(),new Date().getTime());
            try {
                System.out.println(messageDetails);
                MessageDetails savedMessage = messageRepository.save(messageDetails);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
