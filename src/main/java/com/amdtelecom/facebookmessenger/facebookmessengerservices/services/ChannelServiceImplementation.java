package com.amdtelecom.facebookmessenger.facebookmessengerservices.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.AlreadyPresentException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.MissingItemsException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.ChannelRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.PrincipalRepository;

@Service
public class ChannelServiceImplementation implements ChannelService {
	@Autowired
	ChannelRepository channelRepository;
	
	@Autowired
	PrincipalRepository principalRepository;
	
	public MessengerServicePrincipal getPrincipal(String principalId) 
			throws NullPointerException, NoItemsFoundException {
		if (principalId == null)
			throw new NullPointerException("Missing princpalId");
		MessengerServicePrincipal matchingPrincipal =  principalRepository.findByPrincipalId(principalId);
		if (matchingPrincipal == null)
			throw new NoItemsFoundException("principalId", "No matches");
		return matchingPrincipal;
	}

	@Override
	public MessengerServiceChannel createChannel(String principalId, String channelName,
			String appId, String appSecret, String pageId,	String pageAccessToken,
			String verifyToken, String callbackStatusUrl,
			String callbackInboundUrl) 
					throws NullPointerException, NoItemsFoundException, AlreadyPresentException, 
					MissingItemsException {
		if (principalId == null || principalId.trim().length() == 0) {
			throw new NullPointerException("Missing principalId");
		}
		if (channelName == null || channelName.trim().length() == 0) {
			throw new NullPointerException("Missing channelName");
		}
		if (appId == null || appId.trim().length() == 0) {
			throw new MissingItemsException("appId", "Bad credentials");
		}
		if (appSecret == null || appSecret.trim().length() == 0) {
			throw new MissingItemsException("appSecret", "Bad credentials");
		}
		if (pageId == null) {
			throw new MissingItemsException("pageId", "Bad credentials");
		}
		if (pageAccessToken == null || pageAccessToken.trim().length() == 0) {
			throw new MissingItemsException("pageAccessToken", "Bad credentials");
		}
		if (verifyToken == null || verifyToken.trim().length() == 0) {
			throw new MissingItemsException("verifyToken", "Bad credentials");
		}
		if (callbackInboundUrl == null || callbackInboundUrl.trim().length() == 0) {
			throw new MissingItemsException("callbackInboundUrl", "Bad credentials");
		}
		if (callbackStatusUrl== null || callbackStatusUrl.trim().length() == 0) {
			throw new MissingItemsException("callbackStatusUrl", "Bad credentials");
		}

		getPrincipal(principalId);
		UUID newChannelId = UUID.randomUUID();
		Long creationMillis = new Date().getTime();
		MessengerServiceChannel channel = new MessengerServiceChannel(principalId, 
				newChannelId.toString(), channelName, appId, appSecret, pageId, 
				pageAccessToken, verifyToken, callbackInboundUrl, callbackStatusUrl,
				creationMillis, creationMillis);
		try {
			MessengerServiceChannel savedChannel = channelRepository.save(channel);
			return savedChannel;
		} catch (DuplicateKeyException dke) {
			throw new AlreadyPresentException(new String[] {"principalId", "channelName"}, 
					"combination exists");
		}
	}

	@Override
	public List<MessengerServiceChannel> getAllChannelsForPrincipal(String principalId)
			throws NullPointerException, NoItemsFoundException {
		if (principalId == null || principalId.trim().length() == 0) {
			throw new NullPointerException("Missing principalId");
		}
		getPrincipal(principalId);
		List<MessengerServiceChannel> matchingChannels = 
				channelRepository.findByPrincipalId(principalId);
		if (matchingChannels==null || matchingChannels.size() == 0) {
			throw new NoItemsFoundException("principalId", "No matches");
		} 
		return matchingChannels;
	}

	@Override
	public MessengerServiceChannel getChannelForPrincipal(String principalId, String channelId)
			throws NullPointerException, NoItemsFoundException {
		if (principalId == null || principalId.trim().length() == 0) {
			throw new NullPointerException("Missing principalId");
		}
		if (channelId == null || channelId.trim().length() == 0) {
			throw new NullPointerException("Missing channelId");
		}
		getPrincipal(principalId);
		MessengerServiceChannel matchingChannel = 
				channelRepository.findByPrincipalIdAndChannelId(principalId, channelId);
		if (matchingChannel == null) {
			throw new NoItemsFoundException("channelId", "No matches");
		} 
		return matchingChannel;
	}

	@Override
	public MessengerServiceChannel updateChannel(String principalId, String channelId, 
			String channelName,	String pageAccessToken,	String verifyToken, String callbackStatusUrl,
			String callbackInboundUrl) throws NullPointerException, NoItemsFoundException, 
			AlreadyPresentException {
		
		MessengerServiceChannel matchingChannel = getChannelForPrincipal(principalId, 
				channelId);
		
		boolean updated = false;
		if (channelName!=null) { // update projectName
			matchingChannel.setChannelName(channelName);
			updated = true;
		} 
		if (pageAccessToken!=null) { // update pageAccessToken
			matchingChannel.setPageAccessToken(pageAccessToken);
			updated = true;
		} 
		if (verifyToken!=null) { // update verifyToken
			matchingChannel.setVerifyToken(verifyToken);
			updated = true;
		} 
		if (callbackInboundUrl!=null) { // update callbackInboundUrl
			matchingChannel.setCallbackInboundUrl(callbackInboundUrl);
			updated = true;
		} 
		if (callbackStatusUrl!=null) { // update callbackInboundUrl
			matchingChannel.setCallbackStatusUrl(callbackStatusUrl);
		}
		if (updated) { // save updates
			try {
				matchingChannel.setUpdatedAt(new Date().getTime());
				return channelRepository.save(matchingChannel);
			} catch (DuplicateKeyException dke) {
				throw new AlreadyPresentException(
						new String[] {"principalId", "channelName"}, "already present");
			}
		} else {
			return null;
		}
	}

	@Override
	public MessengerServiceChannel deleteChannelForPrincipal(String principalId, 
			String channelId) throws NullPointerException, NoItemsFoundException {
		MessengerServiceChannel matchingChannel = getChannelForPrincipal(principalId, channelId);
		channelRepository.delete(matchingChannel);
		return matchingChannel;
	}
}
