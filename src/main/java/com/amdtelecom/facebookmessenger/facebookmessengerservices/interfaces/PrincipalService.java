package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PrincipalService {
    MessengerServicePrincipal createPrincipal(String platformId, Map<String, String> metadata);
    List<MessengerServicePrincipal> getPrincipals(String platformId);
    MessengerServicePrincipal getSpecificPrincipal(String principalId);
}
