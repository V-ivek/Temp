package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;

@Repository
public interface ChannelRepository extends CrudRepository<MessengerServiceChannel, String>{
	public List<MessengerServiceChannel> findByPrincipalId(String principalId);
	public MessengerServiceChannel findByPrincipalIdAndChannelId(String principalId, String channelId);
	public boolean existsByPrincipalIdAndChannelId(String principalId, String channelId);
}
