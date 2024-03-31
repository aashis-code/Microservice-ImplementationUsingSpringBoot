package com.Microservice.hotelService.Service;

import java.util.List;

import com.Microservice.hotelService.Entity.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getHotel(String id);

}
