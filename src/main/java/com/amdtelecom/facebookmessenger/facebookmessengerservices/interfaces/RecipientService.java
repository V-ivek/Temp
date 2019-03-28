package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Recipient;

import java.util.List;

public interface RecipientService {
    public Recipient createRecipientForChannel(String principalId, String channelId,
                                               String facebookPsid) throws NullPointerException, NoItemsFoundException;
    public Recipient deleteRecipientForChannel(String principalId, String channelId,
                                               String facebookPsid) throws NullPointerException, NoItemsFoundException;
    public List<Recipient> getAllRecipientsForChannel(String principalId,
                                                      String channelId) throws NullPointerException, NoItemsFoundException;
}
