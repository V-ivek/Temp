package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Recipient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipientRepository extends MongoRepository<Recipient,String> {

    List<Recipient> getRecipientsByChannelIdAndPrincipalId(String channelId, String principalId);

}
