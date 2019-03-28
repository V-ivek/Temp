package com.amdtelecom.facebookmessenger.facebookmessengerservices.principal.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.services.PrincipalServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrincipalServiceTests {
	
	@Autowired
	private PrincipalServiceImplementation principalService;

	@Test
	public void createPrincipalAllSuccess() {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal principal = new MessengerServicePrincipal("UnitTestService1", metadata);
		MessengerServicePrincipal saved = principalService.createPrincipal(principal.getPrincipalId(), principal.getMetadata());
		String principalId = saved.getPrincipalId();
		assertThat(saved.getPrincipalId()).isNotNull();
	}
	
	@Test(expected=NullPointerException.class) 
	public void createPrincipalFailOnIncorrectPlatform() throws NullPointerException{
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		principalService.createPrincipal(null, metadata);
	}
	
	@Test(expected=NullPointerException.class)
	public void createPrincipalFailOnEmptyMetadata() {
		MessengerServicePrincipal principal = new MessengerServicePrincipal("UnitTestService3", null);
		principalService.createPrincipal(principal.getPrincipalId(), principal.getMetadata());
	}
	
	@Test
	public void getPrincipalsForPlatformAllGood() throws NullPointerException, NoItemsFoundException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal saved = principalService.createPrincipal("UnitTestService4", metadata);
		String principalId = saved.getPrincipalId();
		assertThat(saved.getPrincipalId()).isNotNull();

		List <MessengerServicePrincipal> result = principalService.getPrincipalsForPlatform("UnitTestService4");
		assertThat(result).isNotEmpty();
	}
	
	@Test(expected=NoItemsFoundException.class)
	public void getPrincipalsForInvalidPlatform() throws NullPointerException, NoItemsFoundException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal saved = principalService.createPrincipal("UnitTestService5", metadata);
		String principalId = saved.getPrincipalId();
		System.out.println(principalId);
		assertThat(saved.getPrincipalId()).isNotNull();
		List<?> items = principalService.getPrincipalsForPlatform("NOT POSSIBLE PLATFORM");
		System.out.println(items);
	}
	
	@Test(expected=NullPointerException.class)
	public void getPrincipalsForNullPlatform() throws NullPointerException, NoItemsFoundException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal saved = principalService.createPrincipal("UnitTestService6", metadata);
		String principalId = saved.getPrincipalId();
		assertThat(saved.getPrincipalId()).isNotNull();
		List<?> items=principalService.getPrincipalsForPlatform(null);
		System.out.println(items);
	}

	@Test
	public void getPrincipalForPlatformAndPrincipal() throws NullPointerException, NoItemsFoundException {
		Map<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("key1", new int[] {0,0,0});
		metadata.put("key2", "sometext");
		metadata.put("key3", new Date());
		
		MessengerServicePrincipal saved = principalService.createPrincipal("UnitTestService7", metadata);
		String principalId = saved.getPrincipalId();
		assertThat(saved.getPrincipalId()).isNotNull();
		MessengerServicePrincipal princi = principalService.getPrincipalForPlatformAndPrincipal("UnitTestService7", principalId);
		assertThat(princi).isNotNull();
	}
	
}
