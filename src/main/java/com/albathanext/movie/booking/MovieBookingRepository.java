package com.albathanext.movie.booking;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.albathanext.movie.model.MovieBooking;

@Repository
public interface MovieBookingRepository extends MongoRepository<MovieBooking, String>{
	@Query(value="{email:'?0'}")
    List<MovieBooking> findByEmail(String email);
}
