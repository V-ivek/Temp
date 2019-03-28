package com.amdtelecom.facebookmessenger.facebookmessengerservices.channel.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.AlreadyPresentException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.MissingItemsException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.ChannelRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.PrincipalRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.services.ChannelServiceImplementation;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.services.PrincipalServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChannelServiceTests {
	
	@Autowired
	PrincipalRepository principalRepository;
	@Autowired
	ChannelRepository channelRepository;

	@Autowired
	private ChannelServiceImplementation channelService;

	@Autowired
	private PrincipalServiceImplementation principalService;

	@Before
	public void setup() {
		principalRepository.deleteAll();
		channelRepository.deleteAll();
	}

	@After
	public void cleanup() {
		principalRepository.deleteAll();
		channelRepository.deleteAll();
	}

	@Test
	public void createChannelAllSuccess() throws NullPointerException, NoItemsFoundException, 
			AlreadyPresentException, MissingItemsException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal savedPrincipal = 
				principalService.createPrincipal("UnitTestChannelService1", metadata);
		String principalId = savedPrincipal.getPrincipalId();
		assertThat(savedPrincipal.getPrincipalId()).isNotNull();
		
		MessengerServiceChannel savedChannel = 
				channelService.createChannel(principalId, "UnitTestChannelName1", 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
		assertThat(savedChannel.getChannelId()).isNotNull();
	}
	
	@Test(expected=NullPointerException.class) 
	public void createChannelFailOnEmptyPrincipalId() throws NullPointerException, NoItemsFoundException, AlreadyPresentException, MissingItemsException{
		MessengerServiceChannel savedChannel = 
				channelService.createChannel(null, "UnitTestChannelName1", 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
	}
	
	@Test(expected=NullPointerException.class) 
	public void createChannelFailOnEmptyChannelName() throws NullPointerException, NoItemsFoundException, AlreadyPresentException, MissingItemsException{
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal savedPrincipal = 
				principalService.createPrincipal("UnitTestChannelService3", metadata);
		String principalId = savedPrincipal.getPrincipalId();
		assertThat(savedPrincipal.getPrincipalId()).isNotNull();

		MessengerServiceChannel savedChannel = 
				channelService.createChannel(principalId, null, 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
	}
	
	
	@Test
	public void getAllChannelsAllSuccess() throws NullPointerException, NoItemsFoundException, 
				AlreadyPresentException, MissingItemsException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal savedPrincipal = 
				principalService.createPrincipal("UnitTestChannelService4", metadata);
		String principalId = savedPrincipal.getPrincipalId();
		assertThat(savedPrincipal.getPrincipalId()).isNotNull();

		MessengerServiceChannel savedChannel = 
				channelService.createChannel(principalId, "UnitTestChannelName1", 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
		List<MessengerServiceChannel> channelsList= 
				channelService.getAllChannelsForPrincipal(principalId);
		
		assertThat(channelsList).isNotEmpty();
		assertThat(channelsList.size()).isEqualByComparingTo(1); // expect only one item
	}
	
	@Test(expected=NullPointerException.class)
	public void getAllChannelsFailOnEmptyPrincipal() throws NullPointerException, NoItemsFoundException {
		List<MessengerServiceChannel> channelsList= 
				channelService.getAllChannelsForPrincipal(null);
	}
	
	@Test(expected=NoItemsFoundException.class)
	public void getAllChannelsFailOnUnavailablePrincipal() throws NullPointerException, NoItemsFoundException {
		List<MessengerServiceChannel> channelsList= 
				channelService.getAllChannelsForPrincipal("CATCH ME IF YOU CAN");
	}

	@Test
	public void getChannelAllSuccess() throws NullPointerException, NoItemsFoundException, AlreadyPresentException, MissingItemsException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal savedPrincipal = 
				principalService.createPrincipal("UnitTestChannelService8", metadata);
		String principalId = savedPrincipal.getPrincipalId();
		assertThat(savedPrincipal.getPrincipalId()).isNotNull();

		MessengerServiceChannel savedChannel = 
				channelService.createChannel(principalId, "UnitTestChannelName1", 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
		MessengerServiceChannel channel = 
				channelService.getChannelForPrincipal(principalId, savedChannel.getChannelId());
	}
	
	@Test(expected=NullPointerException.class)
	public void getChannelFailOnEmptyPrincipalId() throws NullPointerException, NoItemsFoundException, 
			AlreadyPresentException, MissingItemsException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal savedPrincipal = 
				principalService.createPrincipal("UnitTestChannelService9", metadata);
		String principalId = savedPrincipal.getPrincipalId();
		assertThat(savedPrincipal.getPrincipalId()).isNotNull();

		MessengerServiceChannel savedChannel = 
				channelService.createChannel(principalId, "UnitTestChannelName1", 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
		MessengerServiceChannel channel = 
				channelService.getChannelForPrincipal("", savedChannel.getChannelId());
	}
	
	@Test(expected=NullPointerException.class)
	public void getChannelFailOnEmptyChannelId() throws NullPointerException, NoItemsFoundException, 
			AlreadyPresentException, MissingItemsException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal savedPrincipal = 
				principalService.createPrincipal("UnitTestChannelService10", metadata);
		String principalId = savedPrincipal.getPrincipalId();
		assertThat(savedPrincipal.getPrincipalId()).isNotNull();

		MessengerServiceChannel savedChannel = 
				channelService.createChannel(principalId, "UnitTestChannelName1", 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
		MessengerServiceChannel channel = 
				channelService.getChannelForPrincipal(principalId, "");
	}

	@Test(expected=NullPointerException.class)
	public void getChannelFailOnNullPrincipalId() throws NullPointerException, NoItemsFoundException, 
			AlreadyPresentException, MissingItemsException {
		MessengerServiceChannel savedChannel = 
				channelService.createChannel(null, "UnitTestChannelName1", 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
	}
	
	@Test(expected=NullPointerException.class)
	public void getChannelFailOnNullChannelId() throws NullPointerException, NoItemsFoundException, 
			AlreadyPresentException, MissingItemsException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal savedPrincipal = 
				principalService.createPrincipal("UnitTestChannelService12", metadata);
		String principalId = savedPrincipal.getPrincipalId();
		assertThat(savedPrincipal.getPrincipalId()).isNotNull();

		MessengerServiceChannel savedChannel = 
				channelService.createChannel(principalId, null, 
						"appId1", "72939443jjffd01kds", 1, "asdfgf", "zxcvc", 
						"https://routee.amd.com/channel", "https://routee.amd.com/channel");
	}
}
