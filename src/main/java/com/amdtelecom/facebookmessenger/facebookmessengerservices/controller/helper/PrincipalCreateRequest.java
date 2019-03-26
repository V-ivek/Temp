package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import java.util.Map;

public class PrincipalCreateRequest {
	private Map<String, Object> metadata;
	
	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}
	
	@Override
	public String toString() {
		return (metadata == null)?null:metadata.toString();
	}
}
