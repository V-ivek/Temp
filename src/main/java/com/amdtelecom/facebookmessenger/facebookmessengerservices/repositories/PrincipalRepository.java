package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PrincipalRepository extends MongoRepository<MessengerServicePrincipal,String> {
    @Query(value="{ 'platformId' : ?0, 'principalId' : ?1}",fields="{principalId : 1, metadata: 1, _id : 0}")
    public MessengerServicePrincipal getMessengerServicePrincipalByPrincipalId(String platformId,String principalId);

    @Query(fields="{principalId : 1, metadata: 1, _id : 0}")
    public List<MessengerServicePrincipal> getMessengerServicePrincipalsByPlatformId(String platformId);
}
