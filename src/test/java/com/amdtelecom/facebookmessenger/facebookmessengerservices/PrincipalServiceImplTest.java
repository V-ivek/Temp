package com.amdtelecom.facebookmessenger.facebookmessengerservices;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.InvalidPrincipalException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.PrincipalRepository;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.services.PrincipalServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrincipalServiceImplTest {
    @Mock
    private PrincipalRepository principalRepository;
    @InjectMocks
    private PrincipalServiceImpl principalServiceImpl;

    @Test
    public void testCreatePrincipal() {
        String mockPrincipalId = "mock-principal-id-123-5678";
        Map<String, String> metadata = new HashMap();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");
        MessengerServicePrincipal mockPrincipal = new MessengerServicePrincipal(mockPrincipalId, "platform-id-1", metadata, new Date(), new Date());
        when(principalRepository.save(mockPrincipal)).thenReturn(mockPrincipal);
        assertEquals(null, principalServiceImpl.createPrincipal("platform-id-1", metadata));
    }
    @Test
    public void testGetPrincipalDetails() throws InvalidPrincipalException {
        String mockPlatformId = "mock-platform-id-123-5678";
        String mockPrincipalId = "mock-principal-id-123-5678";
        Map<String, String> metadata = new HashMap();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");
        MessengerServicePrincipal mockPrincipal = new MessengerServicePrincipal(mockPrincipalId, mockPlatformId, metadata, new Date(), new Date());
        when(principalRepository.getMessengerServicePrincipalByPrincipalId(mockPlatformId, mockPrincipalId)).thenReturn(mockPrincipal);
        assertEquals("mock-principal-id-123-5678", principalServiceImpl.getSpecificPrincipal(mockPlatformId, mockPrincipalId).getPrincipalId());
    }
    @Test(expected = InvalidPrincipalException.class)
    public void testGetPrincipalDetailsForInvalidPrincipal() throws InvalidPrincipalException {
        String mockPlatformId = "mock-platform-id-123-invalid";
        String mockPrincipalId = "mock-principal-id-123-5678";
        Map<String, String> metadata = new HashMap();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");
        MessengerServicePrincipal mockPrincipal = new MessengerServicePrincipal(mockPrincipalId, mockPlatformId, metadata, new Date(), new Date());
        when(principalRepository.getMessengerServicePrincipalByPrincipalId(mockPlatformId, mockPrincipalId)).thenReturn(null);
        principalServiceImpl.getSpecificPrincipal(mockPlatformId, mockPrincipalId);
    }
    @Test
    public void testGetAllPrincipals() {
        String mockPlatformId = "mock-platform-id-123-5678";
        Map<String, String> metadata = new HashMap();
        metadata.put("key1", "value1");
        metadata.put("key2", "value2");
        MessengerServicePrincipal mockPrincipal1 = new MessengerServicePrincipal("mock-principal-id-123-5678", mockPlatformId, metadata, new Date(), new Date());
        MessengerServicePrincipal mockPrincipal2 = new MessengerServicePrincipal("mock-principal-id-123-5679", mockPlatformId, metadata, new Date(), new Date());
        List<MessengerServicePrincipal> mockPrincipalList = new ArrayList<>();
        mockPrincipalList.add(mockPrincipal1);
        mockPrincipalList.add(mockPrincipal2);
        when(principalRepository.getMessengerServicePrincipalsByPlatformId(mockPlatformId)).thenReturn(mockPrincipalList);
        assertEquals(mockPrincipalList, principalServiceImpl.getPrincipals(mockPlatformId));
    }
}
