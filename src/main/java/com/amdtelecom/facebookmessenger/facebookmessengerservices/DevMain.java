package com.amdtelecom.facebookmessenger.facebookmessengerservices;

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
        p.startPrincipalFlow();
    }

    @Autowired
    PrincipalService pService;
    public void startPrincipalFlow() {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");
        metadata.put("key3", "value3");
        List<MessengerServicePrincipal> principal = pService.getMessengerServicePrincipalsByPlatformId("12345-xxvcb");
        System.out.println("principal created is " + principal);
    }
}

