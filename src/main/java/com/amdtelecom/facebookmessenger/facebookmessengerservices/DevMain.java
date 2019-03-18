package com.amdtelecom.facebookmessenger.facebookmessengerservices;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ComponentScan(basePackages = ("com.amdtelecom.facebookmessenger.facebookmessengerservices"))
public class DevMain {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(DevMain.class);

        DevMain p = context.getBean(DevMain.class);
        p.startChannelFlow();
    }


    @Autowired
    ChannelService channelService;
    public void startChannelFlow() {
        Map<String, String> credentials = new HashMap<String, String>();
        credentials.put("appId", "1");
        credentials.put("appSecret", "2");
        credentials.put("pageId", "3");
        credentials.put("pageAccessToken", "4");
        credentials.put("verifyToken", "5");
        credentials.put("callbackStatusUrl", "6");
        credentials.put("callbackInboundUrl", "7");
        System.out.println("Reached here1" + credentials);
//        MessengerServiceChannel channel = channelService.createChannel("testChannel",credentials,"aa8fb3fc-c9e0-48cd-bc22-58a5f6bc3403");
//        System.out.println("Channel created is " + channel);
        List<MessengerServiceChannel> channels = channelService.getAllChannelsOfPrincipal("aa8fb3fc-c9e0-48cd-bc22-58a5f6bc3403");
        System.out.println("Channels are " + channels.size());
    }
    @Autowired
    PrincipalService principalService;
    public void startPrincipalFlow() {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");
        metadata.put("key3", "value3");
        MessengerServicePrincipal principal = principalService.createPrincipal("12345-xxvcb",metadata);
        System.out.println("principal created is " + principal);
    }
}

