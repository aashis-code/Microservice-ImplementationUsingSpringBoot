package com.Microservice.hotelService.Exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource not found");
	}
}
