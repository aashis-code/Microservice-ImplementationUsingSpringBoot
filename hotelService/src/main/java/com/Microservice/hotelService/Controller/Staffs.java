package com.Microservice.hotelService.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/staffs")
public class Staffs {

	@GetMapping("/")
	public ResponseEntity<?> getStaffs(){
		List<String> asList = Arrays.asList("Aashis","Hari","Shyam");
		return new ResponseEntity<>(asList,HttpStatus.OK);
	}
}
