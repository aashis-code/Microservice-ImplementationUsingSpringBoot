package com.Microservice.hotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.hotelService.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
