package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.ErrorResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.GenericException;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.exceptions.GenericException.ERROR_CODE;

@RestControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ErrorResponse> handleGenericExceptions(GenericException ex) {
		if (ex.getCode() == ERROR_CODE.NOT_FOUND) {
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse(ex.getCode().getIntegerCode(), ex.getMessage(), 
							ex.getType(), "failed"), HttpStatus.NOT_FOUND);			
		} else if (ex.getCode() == ERROR_CODE.INCORRECT_FORMAT){
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse(ex.getCode().getIntegerCode(), ex.getMessage(), 
							ex.getType(), "failed"), HttpStatus.BAD_REQUEST);			
		} else if (ex.getCode() == ERROR_CODE.ALREADY_PRESENT){
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse(ex.getCode().getIntegerCode(), ex.getMessage(), 
							ex.getType(),"failed"),	HttpStatus.NOT_ACCEPTABLE);
		} else if (ex.getCode() == ERROR_CODE.MISSING_ELEMENT){
			return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(ex.getCode().getIntegerCode(), ex.getMessage(), 
						ex.getType(),"failed"),	HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), ex.getType(), "failed"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleUnreadableMsgExceptions(HttpMessageNotReadableException ex) {
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Content unreadable", "failed"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ErrorResponse> handleMissingRequestHeaderExceptions(MissingRequestHeaderException ex) {
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Header unavailable", "failed"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorResponse> handleMissingRequestHeaderExceptions(MissingServletRequestParameterException ex) {
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Request parameter incorrect", "failed"),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericExceptions(Exception ex) {
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), "Generic", "failed"),
				HttpStatus.INTERNAL_SERVER_ERROR);			
	}

}
