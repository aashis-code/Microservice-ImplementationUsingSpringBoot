package com.Microservice.UserService.Exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> resourceNotFoundException(){
		
		return new ResponseEntity<>(Map.of("MESSAGE","Resource not found"),HttpStatus.NOT_FOUND);
	}

}
