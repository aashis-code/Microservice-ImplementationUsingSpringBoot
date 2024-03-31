package com.Microservice.RatingService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.RatingService.Entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
	
	List<Rating>findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
