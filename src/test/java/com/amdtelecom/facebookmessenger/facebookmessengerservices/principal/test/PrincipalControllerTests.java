package com.amdtelecom.facebookmessenger.facebookmessengerservices.principal.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.GenericPrincipalResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.PrincipalCreateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PrincipalControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	
	private JacksonTester<PrincipalCreateRequest> createRequestJson;
	private JacksonTester<GenericPrincipalResponse> genericResponseJson;
	
	@Before
	public void setup() {
		ObjectMapper objectMapper = new ObjectMapper();
		JacksonTester.initFields(this, objectMapper);
	}
	
	@Test
	public void testPrincipalCreationAllSuccess() throws Exception {
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("platformId", "platform-1");
		
		String toPostBody = createRequestJson.write(principalCreateRequest).getJson();
		
		this.mvc.perform(
			post("/principal").
			headers(headers).
			contentType(MediaType.APPLICATION_JSON).
			accept(MediaType.APPLICATION_JSON).
			content(toPostBody)).
				andExpect(MockMvcResultMatchers.status().isCreated()).
				andExpect(MockMvcResultMatchers.content().string(containsString("principalId")));
	}

	@Test
	public void testPrincipalCreationFailOnInvalidPlatformId() throws Exception {
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("unexpectedplatformId", "platform-1");
		
		String toPostBody = createRequestJson.write(principalCreateRequest).getJson();
		
		this.mvc.perform(
				post("/principal").
				headers(headers).
				contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON).
				content(toPostBody)).
					andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testPrincipalRetrieval() throws Exception {
		PrincipalCreateRequest principalCreateRequest = 
				new PrincipalCreateRequest();
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		principalCreateRequest.setMetadata(metadata);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("platformId", "platform-1");
		
		String toPostBody = createRequestJson.write(principalCreateRequest).getJson();
		
		MvcResult createdResult = this.mvc.perform(
			post("/principal").
			headers(headers).
			contentType(MediaType.APPLICATION_JSON).
			accept(MediaType.APPLICATION_JSON).
			content(toPostBody)).
				andExpect(MockMvcResultMatchers.status().isCreated()).
				andExpect(MockMvcResultMatchers.content().string(containsString("principalId"))).
				andReturn();

		String toCrossCheckReturn = createdResult.getResponse().getContentAsString();

		GenericPrincipalResponse createResultJson = 
				genericResponseJson.parseObject( toCrossCheckReturn );
		
		this.mvc.perform(
				get("/principal/"+createResultJson.getPrincipalId()).
				headers(headers).
				contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON)).
					andExpect(MockMvcResultMatchers.status().isOk()).
					andExpect(MockMvcResultMatchers.content().json(toCrossCheckReturn));
	}
}
