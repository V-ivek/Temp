package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.RecipientService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Recipient;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.ChannelRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RecipientServiceImplementation implements RecipientService {

    @Autowired
    RecipientRepository recipientRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Override
    public Recipient createRecipientForChannel(String principalId, String channelId, String facebookPsid) throws NullPointerException, NoItemsFoundException {
        if(principalId == null) {
            throw new NullPointerException("Missing principalId");
        }
        if(channelId == null) {
            throw new NullPointerException("Missing channelId");
        }
        if(facebookPsid == null) {
            throw new NullPointerException("Missing deviceToken");
        }
        if (!channelRepository.existsByPrincipalIdAndChannelId(principalId, channelId)) {
            throw new NoItemsFoundException(new String[] {"principalId", "channelId"},  "No matches");
        }
        Recipient toCreate = new Recipient(principalId, channelId, facebookPsid,
                new Date().getTime(), new Date().getTime());
        return recipientRepository.save(toCreate);
    }

    @Override
    public Recipient deleteRecipientForChannel(String principalId, String channelId, String facebookPsid) throws NullPointerException, NoItemsFoundException {
        if(principalId == null) {
            throw new NullPointerException("Missing principalId");
        }
        if(channelId == null) {
            throw new NullPointerException("Missing channelId");
        }
        if(facebookPsid == null) {
            throw new NullPointerException("Missing deviceToken");
        }
        if (!channelRepository.existsByPrincipalIdAndChannelId(principalId, channelId)) {
            throw new NoItemsFoundException(new String[] {"principalId", "channelId"},  "No matches");
        }
        Recipient matchingRecipient = recipientRepository.findByPrincipalIdAndChannelIdAndFacebookPsid(
                principalId, channelId, facebookPsid);
        recipientRepository.delete(matchingRecipient);
        return matchingRecipient;
    }

    @Override
    public List<Recipient> getAllRecipientsForChannel(String principalId, String channelId) throws NullPointerException, NoItemsFoundException {
        if(principalId == null) {
            throw new NullPointerException("Missing principalId");
        }
        if(channelId == null) {
            throw new NullPointerException("Missing channelId");
        }
        if (!channelRepository.existsByPrincipalIdAndChannelId(principalId, channelId)) {
            throw new NoItemsFoundException(new String[] {"principalId", "channelId"},  "No matches");
        }
        List<Recipient> matchingRecipients = recipientRepository.findByPrincipalIdAndChannelId(
                principalId, channelId);
        return matchingRecipients;
    }
}
