package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.PrincipalService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.PrincipalRepository;

@Service
public class PrincipalServiceImplementation implements PrincipalService {
	@Autowired
	private PrincipalRepository principalRepository;
	
	@Override
	public MessengerServicePrincipal createPrincipal(String platformId, Map<String, Object> metadata) 
			throws NullPointerException {
		if(platformId == null || platformId.trim().isEmpty()) {
			throw new NullPointerException("Missing platformId");
		}
		if (metadata == null) {
			throw new NullPointerException("Missing metadata");
		}
		MessengerServicePrincipal p = new MessengerServicePrincipal(platformId, metadata);
		return principalRepository.save(p);
	}
	
	@Override
	public List<MessengerServicePrincipal> getPrincipalsForPlatform(String platformId) 
			throws NullPointerException, NoItemsFoundException {
		if(platformId == null || platformId.trim().isEmpty()) {
			throw new NullPointerException("Missing platformId");
		}
		List<MessengerServicePrincipal> toReturn = principalRepository.findByPlatformId(platformId);
		if (toReturn == null || toReturn.isEmpty()) {
			throw new NoItemsFoundException("platformId", "No matches");
		}
		return toReturn;
	}

	@Override
	public MessengerServicePrincipal getPrincipalForPlatformAndPrincipal(String platformId, 
			UUID principalId) throws NullPointerException, NoItemsFoundException {
		if(platformId == null || platformId.trim().isEmpty()) {
			throw new NullPointerException("Missing platformId");
		}
		if (principalId == null) {
			throw new NullPointerException("Missing principalId");
		}
		MessengerServicePrincipal toReturn = 
				principalRepository.findByPlatformIdAndPrincipalId(platformId, principalId.toString());
		if (toReturn == null) {
			throw new NoItemsFoundException("principalId", "No matches");
		}
		return toReturn;
	}
	
	@Override
	public MessengerServicePrincipal getPrincipalForPlatformAndPrincipal(String platformId, 
			String principalId) throws NullPointerException, NoItemsFoundException {
		if(platformId == null || platformId.trim().isEmpty()) {
			throw new NullPointerException("Missing platformId");
		}
		if (principalId == null) {
			throw new NullPointerException("Missing principalId");
		}
		MessengerServicePrincipal toReturn = 
				principalRepository.findByPlatformIdAndPrincipalId(platformId, principalId.toString());
		if (toReturn == null) {
			throw new NoItemsFoundException("principalId", "No matches");
		}
		return toReturn;
	}
}
