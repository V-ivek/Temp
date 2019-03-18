package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.InvalidPrincipalException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.PrincipalService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.PrincipalRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PrincipalServiceImpl implements PrincipalService {
    @Autowired
    PrincipalRepository principalRepository;

    public MessengerServicePrincipal createPrincipal(String platformId, Map<String, String> metadata) {
        String principalId = Utility.generateUuid();
        MessengerServicePrincipal principal = new MessengerServicePrincipal(principalId, platformId, metadata, new ArrayList<MessengerServiceChannel>(), new Date(), new Date());
        principalRepository.save(principal);
        return principal;
    }

    public List<MessengerServicePrincipal> getPrincipals(String platformId){
        List<MessengerServicePrincipal> principals = new ArrayList<MessengerServicePrincipal>();
        principals = principalRepository.getMessengerServicePrincipalsByPlatformId(platformId);
        return principals;
    }
    public MessengerServicePrincipal getSpecificPrincipal(String principalId,String platformId) throws InvalidPrincipalException {
        MessengerServicePrincipal principal = principalRepository.getMessengerServicePrincipalByPrincipalId(platformId,principalId);
        if(principal == null){
            throw new InvalidPrincipalException("PrincipalId corresponding to given platformId does not exist");
        }
        else {
            return principal;
        }

    }
}
