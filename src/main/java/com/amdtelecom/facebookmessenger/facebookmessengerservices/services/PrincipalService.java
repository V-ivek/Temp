package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.PrincipalRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Service
public class PrincipalService {
    @Autowired
    PrincipalRepository principalRepository;

    public MessengerServicePrincipal createPrincipal(String platformId, Map<String, String> metadata) {
        //TODO: create a principal and return it
        String principalId = Utility.generateUuid();
        MessengerServicePrincipal principal = new MessengerServicePrincipal(principalId, platformId, metadata, new ArrayList<MessengerServiceChannel>(), new Date(), new Date());
        principalRepository.save(principal);
        return principal;
    }
}
