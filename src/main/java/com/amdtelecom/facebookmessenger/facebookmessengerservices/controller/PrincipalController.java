package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.GenericPrincipalResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.ListOfPrincipalsResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.PrincipalCreateRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.GenericException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.GenericException.ERROR_CODE;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.PrincipalService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServicePrincipal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController()
public class PrincipalController {
	@Autowired
	PrincipalService principalService;

	@PostMapping("/facebook/principal")
	public ResponseEntity<GenericPrincipalResponse> create(
			@RequestBody PrincipalCreateRequest request, @RequestHeader String platformId)
			throws GenericException {
		MessengerServicePrincipal saved = null;
		try {
			saved = principalService.createPrincipal(platformId, request.getMetadata());
		} catch (NullPointerException e) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, e.getMessage(), "Bad request");
		}
		GenericPrincipalResponse response = new GenericPrincipalResponse(
				saved.getPrincipalId().toString(), saved.getMetadata(), saved.getCreatedAt());
		return new ResponseEntity<GenericPrincipalResponse>(response, HttpStatus.CREATED);
	}

	@GetMapping("/facebook/principal")
	public ResponseEntity<ListOfPrincipalsResponse> getAllPrincipals(
			@RequestHeader String platformId) throws GenericException {
		List<MessengerServicePrincipal> principals = null;
		try {
			principals = principalService.getPrincipalsForPlatform(platformId);
		} catch (NullPointerException e) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, e.getMessage(), "Bad request");
		} catch (NoItemsFoundException e) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, Arrays.toString(e.getItems()) + " " + e.getMessage(), "Bad request");
		}
		List<GenericPrincipalResponse> listOfPrincipals = new ArrayList<GenericPrincipalResponse>();
		principals.forEach(principal -> {
			listOfPrincipals.add(new GenericPrincipalResponse(principal.getPrincipalId(),
					principal.getMetadata(), principal.getCreatedAt()));
		});
		
		ListOfPrincipalsResponse toReturn = new ListOfPrincipalsResponse(listOfPrincipals, 
				1, true, listOfPrincipals.size(), true, listOfPrincipals.size(), 1);
		return new ResponseEntity<ListOfPrincipalsResponse>(toReturn, HttpStatus.OK);
	}

	@GetMapping("/facebook/principal/{principalId}")
	public ResponseEntity<GenericPrincipalResponse> getPrincipal(@RequestHeader String platformId,
			@PathVariable String principalId) throws GenericException {
		MessengerServicePrincipal toReturn = null;
		try {
			toReturn = principalService.getPrincipalForPlatformAndPrincipal(platformId, principalId);
		} catch (NullPointerException e) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, e.getMessage(), "Bad request");
		} catch (NoItemsFoundException e) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, Arrays.toString(e.getItems()) + " " + e.getMessage(), "Bad request");
		}
		GenericPrincipalResponse response = new GenericPrincipalResponse(
				toReturn.getPrincipalId().toString(), toReturn.getMetadata(), toReturn.getCreatedAt());
		return new ResponseEntity<GenericPrincipalResponse>(response, HttpStatus.OK);
	}

}
