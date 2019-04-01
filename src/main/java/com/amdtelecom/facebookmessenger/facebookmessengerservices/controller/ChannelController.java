package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller;


import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.*;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.RecipientService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.AlreadyPresentException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.GenericException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.NoItemsFoundException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.GenericException.ERROR_CODE;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.MissingItemsException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.ChannelService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class ChannelController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private RecipientService recipientService;
	
	@PostMapping(path="/facebook/channel")
	public ResponseEntity<GenericChannelResponse> createChannel(
			@RequestBody ChannelCreateRequest request,
			@RequestHeader String principalId
		) throws GenericException {
		
		MessengerServiceChannel saved = null;
		try {
			saved = channelService.createChannel(
					principalId, request.getChannelName(), request.getAppId(), 
					request.getAppSecret(), request.getPageId(), request.getPageAccessToken(),
					request.getVerifyToken(), request.getCallbackStatusUrl(), 
					request.getCallbackInboundUrl());
		} catch (NullPointerException ex) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, ex.getMessage(), "Bad request");
		} catch (NoItemsFoundException e) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, "User doesn't exist", 
					"Bad "+Arrays.toString(e.getItems()));
		} catch(AlreadyPresentException ape) {
			throw new GenericException(ERROR_CODE.ALREADY_PRESENT, 
					Arrays.toString(ape.getItemSetPresent())+" "+ape.getMessage(), "Bad channelName");
		} catch (MissingItemsException mie) {
			throw new GenericException(ERROR_CODE.MISSING_ELEMENT, mie.getItemsAsMessage(), 
				"Bad credentials");
		}
		GenericChannelResponse response = 
				new GenericChannelResponse( saved.getChannelId(), saved.getChannelName(), 
						saved.getAppId(), saved.getAppSecret(),	saved.getPageId(), 
						saved.getPageAccessToken(), saved.getVerifyToken(), 
						saved.getCallbackStatusUrl(), saved.getCallbackInboundUrl(), 
						new Date(saved.getCreatedAt()),	new Date(saved.getUpdatedAt()));
		return new ResponseEntity<GenericChannelResponse>(response, 
				HttpStatus.CREATED);
	}
	
	@GetMapping(path="/facebook/channel")
	public ResponseEntity<ListOfChannelsResponse> getAllChanels(
			@RequestHeader String principalId) throws GenericException  {
		List<MessengerServiceChannel> channels = null;
		try {
			channels = channelService.getAllChannelsForPrincipal(principalId);			
		} catch (NullPointerException ex) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, ex.getMessage(), 
					"Bad principalId");
		} catch (NoItemsFoundException ex) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, 
					Arrays.toString(ex.getItems())+" "+ex.getMessage(), "Empty list");
		}
		
		List<GenericChannelResponse> channelsList = 
				new ArrayList<GenericChannelResponse>();
		channels.forEach(saved -> {
			channelsList.add(
					new GenericChannelResponse( saved.getChannelId(), saved.getChannelName(), 
							saved.getAppId(), saved.getAppSecret(),	saved.getPageId(), 
							saved.getPageAccessToken(), saved.getVerifyToken(), 
							saved.getCallbackStatusUrl(), saved.getCallbackInboundUrl(), 
							new Date(saved.getCreatedAt()),	new Date(saved.getUpdatedAt())));
		});
		ListOfChannelsResponse toReturn = new ListOfChannelsResponse(
				channelsList, 1, true, channels.size(), true, -1, 1);
		return new ResponseEntity<ListOfChannelsResponse>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping(path="/facebook/channel/{channelId}")
	public ResponseEntity<GenericChannelResponse> getAllChanels(
			@RequestHeader String principalId, @PathVariable String channelId
		) throws GenericException  {
		
		MessengerServiceChannel saved = null;
		try {
			saved = channelService.getChannelForPrincipal(principalId, channelId);			
		} catch (NullPointerException ex) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, ex.getMessage(), 
					"Bad principalId");
		} catch (NoItemsFoundException ex) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, 
					Arrays.toString(ex.getItems())+" "+ex.getMessage(), "Empty list");
		}
		
		GenericChannelResponse toReturn =
				new GenericChannelResponse( saved.getChannelId(), saved.getChannelName(), 
						saved.getAppId(), saved.getAppSecret(),	saved.getPageId(), 
						saved.getPageAccessToken(), saved.getVerifyToken(), 
						saved.getCallbackStatusUrl(), saved.getCallbackInboundUrl(), 
						new Date(saved.getCreatedAt()),	new Date(saved.getUpdatedAt()));

		return new ResponseEntity<GenericChannelResponse>(toReturn, 
				HttpStatus.OK);
	}

	@DeleteMapping(path="/facebook/channel/{channelId}")
	public ResponseEntity<DeleteResponse> removeOneChanel(
			@RequestHeader String principalId, @PathVariable String channelId
		) throws GenericException  {
		
		MessengerServiceChannel saved = null;
		try {
			saved = channelService.deleteChannelForPrincipal(principalId, channelId);			
		} catch (NullPointerException ex) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, ex.getMessage(), 
					"Bad principalId");
		} catch (NoItemsFoundException ex) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, 
					Arrays.toString(ex.getItems())+" "+ex.getMessage(), "Empty list");
		}
		
		DeleteResponse toReturn =
				new DeleteResponse( "success", "The channel with channel Id"+
						saved.getChannelId()+" is deleted successfully");

		return new ResponseEntity<DeleteResponse>(toReturn,	HttpStatus.OK);
	}

	@PutMapping(path="/facebook/channel/{channelId}")
	public ResponseEntity<UpdateChannelResponse> updateChannel(
			@RequestBody ChannelUpdateRequest request, @PathVariable String channelId,
			@RequestHeader String principalId
		) throws GenericException {
		
		MessengerServiceChannel saved = null;
		try {
			saved = channelService.updateChannel(principalId, channelId, request.getChannelName(),
					request.getPageAccessToken(), request.getVerifyToken(), request.getCallbackStatusUrl(), 
					request.getCallbackInboundUrl());
		} catch (NullPointerException ex) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, ex.getMessage(), "Bad request");
		} catch (NoItemsFoundException e) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, "User doesn't exist", 
					"Bad "+Arrays.toString(e.getItems()));
		} catch(AlreadyPresentException ape) {
			throw new GenericException(ERROR_CODE.ALREADY_PRESENT, 
					Arrays.toString(ape.getItemSetPresent())+" "+ape.getMessage(), "Bad channelName");
		} 
		UpdateChannelResponse response = 
				new UpdateChannelResponse(saved.getChannelName(), saved.getAppId(), saved.getAppSecret(), 
						saved.getPageId(), saved.getPageAccessToken(), saved.getVerifyToken(), 
						saved.getCallbackStatusUrl(), saved.getCallbackInboundUrl(), 
						new Date(saved.getUpdatedAt()));
		return new ResponseEntity<UpdateChannelResponse>(response, HttpStatus.CREATED);
	}

	@PutMapping(path="/facebook/channel/{channelId}/recipient")
	public ResponseEntity<GenericRecipientResponse> addRecipientToChannel(
			@RequestHeader String principalId, @PathVariable String channelId,
			@RequestBody GenericRecipientRequest recipientDetails
	) throws GenericException  {

		Recipient recipient = null;
		try {
			recipient = recipientService.createRecipientForChannel(principalId, channelId,
					recipientDetails.getFacebookPsid());
		} catch (NullPointerException ex) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, ex.getMessage(),"Bad request");
		} catch (NoItemsFoundException ex) {
			throw new GenericException(ERROR_CODE.NOT_FOUND, "User doesn't exist" ,
					Arrays.toString(ex.getItems())+" "+ex.getMessage());
		}

		GenericRecipientResponse toReturn =
				new GenericRecipientResponse(
						recipient.getFacebookPsid(), recipient.getChannelId(),
						new Date(recipient.getUpdatedAt()));

		return new ResponseEntity<GenericRecipientResponse>(toReturn,
				HttpStatus.OK);
	}

	@GetMapping(path="facebook/channel/{channelId}/recipient")
	public ResponseEntity<RecipientListResponse> getAllRecipientsForChannel(
			@RequestHeader String principalId, @PathVariable String channelId)
			throws GenericException  {

		List<Recipient> recipientList = null;
		try {
			recipientList = recipientService.getAllRecipientsForChannel(principalId, channelId);
		} catch (NullPointerException ex) {
			throw new GenericException(ERROR_CODE.INCORRECT_FORMAT, ex.getMessage(),"Bad request");
		} catch (NoItemsFoundException ex) {
			throw new GenericException(ERROR_CODE.NOT_FOUND,"User doesn't exist",
					Arrays.toString(ex.getItems())+" "+ex.getMessage());
		}
		List<RecipientListResponse.Token> list =
				new ArrayList<RecipientListResponse.Token>();
		recipientList.forEach(recipient -> {
			list.add(new RecipientListResponse.Token(
					recipient.getFacebookPsid(), new Date(recipient.getUpdatedAt()))
			);
		});

		RecipientListResponse toReturn =
				new RecipientListResponse(list, channelId);
		return new ResponseEntity<RecipientListResponse>(
				toReturn, HttpStatus.OK);
	}
}
