package com.Microservice.hotelService.ServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.Microservice.hotelService.Entity.Hotel;
import com.Microservice.hotelService.Exception.ResourceNotFoundException;
import com.Microservice.hotelService.Repository.HotelRepository;
import com.Microservice.hotelService.Service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		String string = UUID.randomUUID().toString();
		hotel.setId(string);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
	}

	
	
	
	
	
	
}
