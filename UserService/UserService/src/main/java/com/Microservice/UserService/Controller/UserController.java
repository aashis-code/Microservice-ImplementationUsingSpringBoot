package com.Microservice.UserService.Controller;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Microservice.UserService.Entity.User;
import com.Microservice.UserService.Service.UserService;
import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
@RequestMapping("/users")
public class UserController {
	
	int retryCount = 1;

	@Autowired
	private UserService userService;

	private Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

	// create User
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}

	// single user get
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod =  "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		logger.info("Retry modeule count :{}",retryCount);
		retryCount++;
		User user = userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	// get All users
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	//Create fallback method for service breakdown condition
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		logger.info("Error happen on service :",ex.getMessage());
		User build = User.builder()
				.email("dummy@gmail.com")
				.name("dummy").about("It is dummy.")
				.userId("1234")
				.build();
		return  new ResponseEntity<User>(build, HttpStatus.OK);
	}

}
