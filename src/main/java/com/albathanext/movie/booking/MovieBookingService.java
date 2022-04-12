package com.albathanext.movie.booking;

import java.util.List;

import com.albathanext.movie.model.MovieBooking;

public interface MovieBookingService {
	MovieBooking save(MovieBooking movieBooking);
	List<MovieBooking> findByEmail(String email);
}
