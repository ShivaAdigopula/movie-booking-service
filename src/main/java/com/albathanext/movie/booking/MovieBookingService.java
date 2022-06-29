package com.albathanext.movie.booking;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.albathanext.movie.model.MovieBooking;

public interface MovieBookingService {
	MovieBooking save(MovieBooking movieBooking);
	List<MovieBooking> findByEmail(String email);
	List<MovieBooking> findByKeyAndDateRange(String key, Date fromDate, Date toDate);
	MovieBooking update(String id, MovieBooking movieBooking);
	MovieBooking cancelBooking(String id);
	Page<MovieBooking> getPagedMovieBookings(PageRequest pageRequest);
}
