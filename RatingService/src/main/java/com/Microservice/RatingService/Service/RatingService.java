package com.Microservice.RatingService.Service;

import java.util.List;

import com.Microservice.RatingService.Entity.Rating;

public interface RatingService {

	
	Rating createRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
}
