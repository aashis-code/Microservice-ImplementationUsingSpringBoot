package com.Microservice.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.RatingService.Entity.Rating;
import com.Microservice.RatingService.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	
	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createRating = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> allRatings = ratingService.getAllRatings();
		return ResponseEntity.status(HttpStatus.OK).body(allRatings);
	}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> allRatings = ratingService.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(allRatings);
	}
	
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> allRatings = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(allRatings);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
