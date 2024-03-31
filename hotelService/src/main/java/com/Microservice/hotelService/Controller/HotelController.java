package com.Microservice.hotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.hotelService.Entity.Hotel;
import com.Microservice.hotelService.Service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel create = hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getHotel(){
		List<Hotel> create = hotelService.getAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
	}
	
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
	}
	
	
	
	
	
	
	

}
