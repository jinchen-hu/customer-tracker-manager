package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	public CustomerRestExceptionHandler() {
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handException(CustomerNotFoundException e) {
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handException(Exception e) {
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
