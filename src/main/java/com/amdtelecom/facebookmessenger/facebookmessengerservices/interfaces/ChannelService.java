package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import java.util.List;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.AlreadyPresentException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.MissingItemsException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;

public interface ChannelService {
	public MessengerServiceChannel createChannel(String principalId, String channelName,
			String appId, String appSecret, Integer pageId,	String pageAccessToken, 
			String verifyToken, String callbackStatusUrl,
			String callbackInboundUrl) 
					throws NullPointerException, NoItemsFoundException, AlreadyPresentException, MissingItemsException;
	public List<MessengerServiceChannel> getAllChannelsForPrincipal(String principalId) 
			throws NullPointerException, NoItemsFoundException ;
	public MessengerServiceChannel getChannelForPrincipal(String principalId, 
			String channelId) throws NullPointerException, NoItemsFoundException;
	public MessengerServiceChannel updateChannel(String principalId, String channelId, 
			String channelName,	String pageAccessToken,	String verifyToken, String callbackStatusUrl,
			String callbackInboundUrl) 
					throws NullPointerException, NoItemsFoundException, AlreadyPresentException;
	public MessengerServiceChannel deleteChannelForPrincipal(String principalId, 
			String channelId) throws NullPointerException, NoItemsFoundException;
}
