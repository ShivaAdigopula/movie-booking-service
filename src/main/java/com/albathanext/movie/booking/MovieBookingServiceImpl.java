package com.albathanext.movie.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albathanext.movie.model.MovieBooking;

@Service
public class MovieBookingServiceImpl implements MovieBookingService {
	
	@Autowired
	private MovieBookingRepository movieBookingRepository;

	@Override
	public MovieBooking save(MovieBooking movieBooking) {
		return movieBookingRepository.save(movieBooking);
	}

	@Override
	public List<MovieBooking> findByEmail(String email) {
		
		return movieBookingRepository.findByEmail(email);
	}

}
