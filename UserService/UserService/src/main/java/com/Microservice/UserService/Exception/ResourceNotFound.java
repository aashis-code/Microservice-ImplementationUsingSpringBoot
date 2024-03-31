package com.Microservice.UserService.Exception;

public class ResourceNotFound extends RuntimeException {
	
	public ResourceNotFound() {
		super("Resource not found");
	}

}
