package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServicePrincipal;

public interface PrincipalService {
	public MessengerServicePrincipal createPrincipal(String platformId, 
			Map<String, Object> metadata) throws NullPointerException;
	public List<MessengerServicePrincipal> getPrincipalsForPlatform(String platformId) 
			throws NullPointerException, NoItemsFoundException;
	public MessengerServicePrincipal getPrincipalForPlatformAndPrincipal(String platformId, 
			UUID principalId) throws NullPointerException, NoItemsFoundException;
	public MessengerServicePrincipal getPrincipalForPlatformAndPrincipal(String platformId, 
			String principalId) throws NullPointerException, NoItemsFoundException;
}
