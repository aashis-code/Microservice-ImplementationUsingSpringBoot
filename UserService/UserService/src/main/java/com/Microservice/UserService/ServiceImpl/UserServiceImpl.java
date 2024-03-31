package com.Microservice.UserService.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Microservice.UserService.Entity.Hotel;
import com.Microservice.UserService.Entity.Rating;
import com.Microservice.UserService.Entity.User;
import com.Microservice.UserService.Exception.ResourceNotFound;
import com.Microservice.UserService.ExternalService.HotelService;
import com.Microservice.UserService.Repository.UserRepository;
import com.Microservice.UserService.Service.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	

	private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound());
		
		Rating[] arrayOfRating = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
		List<Rating> ratingList = Arrays.stream(arrayOfRating).toList();
		
		List<Rating> ratingAfterHotel = ratingList.stream().map(rating -> {
			
			Hotel hotelInfo = hotelService.getHotel("37475267-4f6e-4e8c-bfe3-12b1ee356aa3");
			
//		Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/37475267-4f6e-4e8c-bfe3-12b1ee356aa3", Hotel.class);
		rating.setHotel(hotelInfo);
		return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingAfterHotel);
		return user; 
	}

}
