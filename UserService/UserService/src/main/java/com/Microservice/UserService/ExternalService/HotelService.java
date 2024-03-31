package com.Microservice.UserService.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Microservice.UserService.Entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE", path = "/hotels")
public interface HotelService {

	@GetMapping("/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
}
