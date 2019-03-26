package com.amdtelecom.facebookmessenger.facebookmessengerservices.principal.test;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.GenericPrincipalResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.PrincipalCreateRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PrincipalIntegrationTests {
	
	@LocalServerPort
	private int port;
		
	@Test
	public void testPrincipalCreationAllSuccess() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("platformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers);
		ResponseEntity<GenericPrincipalResponse> response =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", request, GenericPrincipalResponse.class);
		assertEquals("Creation of principal failed", 201, response.getStatusCodeValue());
	}

	@Test
	public void testPrincipalCreationFailOnInvalidPlatformId() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("unexpectedplatformId", "platform-1");
		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(
						principalCreateRequest, headers);
		ResponseEntity<GenericPrincipalResponse> response =
				restTemplate.postForEntity("http://localhost:"+port+"/principal",
						request, GenericPrincipalResponse.class);
		assertEquals("Creation of principal failed without valid platformId", 400, 
				response.getStatusCodeValue());
	}

	@Test
	public void testPrincipalRetrieval() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("platformId", "platform-1");
		
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		principalCreateRequest.setMetadata(metadata);

		HttpEntity<PrincipalCreateRequest> request = 
				new HttpEntity<PrincipalCreateRequest>(principalCreateRequest, 
						headers);
		ResponseEntity<GenericPrincipalResponse> createResponse =
				restTemplate.postForEntity("http://localhost:"+port+"/principal", request, 
						GenericPrincipalResponse.class);
		assertEquals(201, createResponse.getStatusCodeValue());
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers); // header reused from above
		ResponseEntity<String> getResponse = 
				restTemplate.exchange("http://localhost:"+port+"/principal", HttpMethod.GET, entity, 
						String.class);
		assertEquals(200, getResponse.getStatusCodeValue());
		try {
			JSONArray json = new JSONArray(getResponse.getBody());
			assertNotEquals(1, json.length());
			assertNotNull(json.getJSONObject(0));
		} catch (JSONException e) {
			fail("Invalid JSOn retrieved for principals", e);
		}
	}
}
