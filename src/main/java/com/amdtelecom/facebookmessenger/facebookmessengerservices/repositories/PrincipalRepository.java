package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrincipalRepository extends MongoRepository<MessengerServicePrincipal,String> {
   
    public MessengerServicePrincipal getMessengerServicePrincipalByPrincipalId(String principalId);

    public List<MessengerServicePrincipal> getMessengerServicePrincipalsByPlatformId(String platformId);
}
