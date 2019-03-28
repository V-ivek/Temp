package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServicePrincipal;

@Repository
public interface PrincipalRepository extends CrudRepository<MessengerServicePrincipal, String>{
	public List<MessengerServicePrincipal> findByPlatformId(String platformId);
	public MessengerServicePrincipal findByPlatformIdAndPrincipalId(String platformId, String principalId);
	public MessengerServicePrincipal findByPrincipalId(String principalId);
}
