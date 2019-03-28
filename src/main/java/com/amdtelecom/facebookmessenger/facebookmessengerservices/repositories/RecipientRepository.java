package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;


import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Recipient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient,String> {

    public List<Recipient> findByPrincipalIdAndChannelId(String principalId,
                                                         String channelId);
    public Recipient findByPrincipalIdAndChannelIdAndFacebookPsid(String principalId,
                                                                 String channelId, String facebookPsid);
}
