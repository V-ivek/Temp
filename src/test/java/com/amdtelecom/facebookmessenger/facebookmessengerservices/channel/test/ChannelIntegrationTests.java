package com.amdtelecom.facebookmessenger.facebookmessengerservices.channel.test;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.ChannelCreateRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.GenericChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.GenericPrincipalResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.PrincipalCreateRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.ChannelRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.PrincipalRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ChannelIntegrationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	PrincipalRepository principalRepository;
	@Autowired
	ChannelRepository channelRepository;
	
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
	public void testSuccessfulChannelCreation() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers1);
		ResponseEntity<GenericPrincipalResponse> principalResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", 
						request, GenericPrincipalResponse.class);
		GenericPrincipalResponse goodPrincipalResponse = 
				principalResponse.getBody();

		ChannelCreateRequest channelCreateRequest = 
				new ChannelCreateRequest(
						"channelName1", "appId1", "appSecret1", "1", "9829mnsdafnsd",
						"28438943mffvmmw", "https://routee.amdtelecom.com/checkfb/",
						"https://routee.amdtelecom.com/checkfb/");
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("principalId", goodPrincipalResponse.getPrincipalId());
		HttpEntity<ChannelCreateRequest> channelRequest = 
				new HttpEntity<ChannelCreateRequest>(channelCreateRequest, 
						headers2);
		ResponseEntity<GenericChannelResponse> response =
				restTemplate.postForEntity("http://localhost:"+port+"/channel", channelRequest, GenericChannelResponse.class);
		assertEquals("Creation of channel failed", HttpStatus.CREATED.value(), 
				response.getStatusCodeValue());
	}

	@Test
	public void testChannelCreationFailOnInvalidPrincipalId() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers1);
		ResponseEntity<GenericPrincipalResponse> principalResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", 
						request, GenericPrincipalResponse.class);
		GenericPrincipalResponse goodPrincipalResponse = 
				principalResponse.getBody();

		ChannelCreateRequest channelCreateRequest = 
				new ChannelCreateRequest(
						"channelName1", "appId1", "appSecret1", "", "9829mnsdafnsd",
						"28438943mffvmmw", "https://routee.amdtelecom.com/checkfb/",
						"https://routee.amdtelecom.com/checkfb/");
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("principalId", null);
		HttpEntity<ChannelCreateRequest> channelRequest = 
				new HttpEntity<ChannelCreateRequest>(channelCreateRequest, 
						headers2);
		ResponseEntity<GenericChannelResponse> response =
				restTemplate.postForEntity("http://localhost:"+port+"/channel", request, GenericChannelResponse.class);
		assertEquals("Creation of channel failed", HttpStatus.BAD_REQUEST.value(), 
				response.getStatusCodeValue());
	}

	@Test
	public void testchannelCreationFailOnInvalidChannelName() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers1);
		ResponseEntity<GenericPrincipalResponse> principalResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", 
						request, GenericPrincipalResponse.class);
		GenericPrincipalResponse goodPrincipalResponse = 
				principalResponse.getBody();

		ChannelCreateRequest channelCreateRequest = 
				new ChannelCreateRequest(
						"channelName1", "appId1", "appSecret1", "1", "9829mnsdafnsd",
						"28438943mffvmmw", "https://routee.amdtelecom.com/checkfb/",
						"https://routee.amdtelecom.com/checkfb/");
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("principalId", goodPrincipalResponse.getPrincipalId());
		HttpEntity<ChannelCreateRequest> channelRequest = 
				new HttpEntity<ChannelCreateRequest>(channelCreateRequest, 
						headers2);
		ResponseEntity<GenericChannelResponse> response =
				restTemplate.postForEntity("http://localhost:"+port+"/channel", request, GenericChannelResponse.class);
		assertEquals("Creation of channel failed", HttpStatus.BAD_REQUEST.value(), 
				response.getStatusCodeValue());
	}

	@Test
	public void testSuccessfulChannelsRetrieval() throws URISyntaxException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers1);
		ResponseEntity<GenericPrincipalResponse> principalResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", 
						request, GenericPrincipalResponse.class);
		GenericPrincipalResponse goodPrincipalResponse = 
				principalResponse.getBody();

		ChannelCreateRequest channelCreateRequest = 
				new ChannelCreateRequest(
						"channelName1", "appId1", "appSecret1", "1", "9829mnsdafnsd",
						"28438943mffvmmw", "https://routee.amdtelecom.com/checkfb/",
						"https://routee.amdtelecom.com/checkfb/");
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("principalId", goodPrincipalResponse.getPrincipalId());
		HttpEntity<ChannelCreateRequest> channelRequest = 
				new HttpEntity<ChannelCreateRequest>(channelCreateRequest, 
						headers2);
		ResponseEntity<String> response =
				restTemplate.postForEntity("http://localhost:"+port+"/channel", channelRequest, String.class);
		assertEquals("Creation of channel failed", HttpStatus.CREATED.value(), 
				response.getStatusCodeValue());
		
		RequestEntity<Void> allChannelsRequest = RequestEntity.get(new URI("http://localhost:"+port+"/channel"))
				.accept(MediaType.APPLICATION_JSON)
				.header("principalId", goodPrincipalResponse.getPrincipalId())
				.build();
		ResponseEntity<String> allChannelsResponse =
				restTemplate.exchange(allChannelsRequest, String.class);
		assertEquals("Retrieval of channels failed", HttpStatus.OK.value(), 
				allChannelsResponse.getStatusCodeValue());

		try {
			JSONArray json = new JSONArray(allChannelsResponse.getBody());
			assertEquals(1, json.length());
			assertNotNull(json.getJSONObject(0));
		} catch (JSONException e) {
			fail("Invalid JSOn retrieved for channels", e);
		}
	}
	
	@Test
	public void testFailedChannelsRetrieval() throws URISyntaxException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers1);
		ResponseEntity<GenericPrincipalResponse> principalResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", 
						request, GenericPrincipalResponse.class);
		GenericPrincipalResponse goodPrincipalResponse = 
				principalResponse.getBody();

		ChannelCreateRequest channelCreateRequest = 
				new ChannelCreateRequest(
						"channelName1", "appId1", "appSecret1", "1", "9829mnsdafnsd",
						"28438943mffvmmw", "https://routee.amdtelecom.com/checkfb/",
						"https://routee.amdtelecom.com/checkfb/");
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("principalId", goodPrincipalResponse.getPrincipalId());
		HttpEntity<ChannelCreateRequest> channelRequest = 
				new HttpEntity<ChannelCreateRequest>(channelCreateRequest, 
						headers2);
		ResponseEntity<String> response =
				restTemplate.postForEntity("http://localhost:"+port+"/channel", channelRequest, String.class);
		assertEquals("Creation of channel failed", HttpStatus.CREATED.value(), 
				response.getStatusCodeValue());
		
		RequestEntity<Void> allChannelsRequest = RequestEntity.get(new URI("http://localhost:"+port+"/channel"))
				.accept(MediaType.APPLICATION_JSON)
				.header("principalId", "") // passing empty string, so surely must fail
				.build();
		ResponseEntity<String> allChannelsResponse =
				restTemplate.exchange(allChannelsRequest, String.class);
		assertEquals("Retrieval of channels failed", HttpStatus.BAD_REQUEST.value(), 
				allChannelsResponse.getStatusCodeValue());
	}

	@Test
	public void testSuccessfulChannelRetrieval() throws URISyntaxException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers1);
		ResponseEntity<GenericPrincipalResponse> principalResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", 
						request, GenericPrincipalResponse.class);
		GenericPrincipalResponse goodPrincipalResponse = 
				principalResponse.getBody();

		ChannelCreateRequest channelCreateRequest = 
				new ChannelCreateRequest(
						"channelName1", "appId1", "appSecret1", "1", "9829mnsdafnsd",
						"28438943mffvmmw", "https://routee.amdtelecom.com/checkfb/",
						"https://routee.amdtelecom.com/checkfb/");
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("principalId", goodPrincipalResponse.getPrincipalId());
		HttpEntity<ChannelCreateRequest> channelRequest = 
				new HttpEntity<ChannelCreateRequest>(channelCreateRequest, 
						headers2);
		ResponseEntity<GenericChannelResponse> createResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/channel", 
						channelRequest, GenericChannelResponse.class);
		assertEquals("Creation of channel failed", HttpStatus.CREATED.value(), 
				createResponse.getStatusCodeValue());
		
		RequestEntity<Void> allChannelsRequest = RequestEntity
				.get(new URI("http://localhost:"+port+"/channel/"+createResponse.getBody().getChannelId()))
				.accept(MediaType.APPLICATION_JSON)
				.header("principalId", goodPrincipalResponse.getPrincipalId())
				.build();
		ResponseEntity<GenericChannelResponse> allChannelsResponse =
				restTemplate.exchange(allChannelsRequest, GenericChannelResponse.class);
		assertEquals("Retrieval of channels failed", HttpStatus.OK.value(), 
				allChannelsResponse.getStatusCodeValue());
	}
	
	@Test
	public void updateChannelSuccess() throws URISyntaxException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers1);
		ResponseEntity<GenericPrincipalResponse> principalResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", 
						request, GenericPrincipalResponse.class);
		GenericPrincipalResponse goodPrincipalResponse = 
				principalResponse.getBody();

		ChannelCreateRequest channelCreateRequest = 
				new ChannelCreateRequest(
						"channelName1", "appId1", "appSecret1", "1", "9829mnsdafnsd",
						"28438943mffvmmw", "https://routee.amdtelecom.com/checkfb/",
						"https://routee.amdtelecom.com/checkfb/");
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("principalId", goodPrincipalResponse.getPrincipalId());
		HttpEntity<ChannelCreateRequest> channelRequest = 
				new HttpEntity<ChannelCreateRequest>(channelCreateRequest, 
						headers2);
		ResponseEntity<GenericChannelResponse> createResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/channel", 
						channelRequest, GenericChannelResponse.class);
		assertEquals("Creation of channel failed", HttpStatus.CREATED.value(), 
				createResponse.getStatusCodeValue());
		
		RequestEntity<Void> allChannelsRequest = RequestEntity
				.get(new URI("http://localhost:"+port+"/channel/"+createResponse.getBody().getChannelId()))
				.accept(MediaType.APPLICATION_JSON)
				.header("principalId", goodPrincipalResponse.getPrincipalId())
				.build();
		ResponseEntity<GenericChannelResponse> allChannelsResponse =
				restTemplate.exchange(allChannelsRequest, GenericChannelResponse.class);
		assertEquals("Retrieval of channels failed", HttpStatus.OK.value(), 
				allChannelsResponse.getStatusCodeValue());
		
	}
	
	
	
	//todo: test to add recipient list to a channel
	//todo: test to delete recipient from channel
	//todo: test to list recipients for a channel
}
