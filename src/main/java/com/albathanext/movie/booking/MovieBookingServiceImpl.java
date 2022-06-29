package com.albathanext.movie.booking;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.albathanext.movie.model.MovieBooking;

@Service
public class MovieBookingServiceImpl implements MovieBookingService {
	
	@Autowired
	private MovieBookingRepository movieBookingRepository;
	
	@Autowired
	private CustomMovieBookingRepository customMovieBookingRepository;

	@Override
	public MovieBooking save(MovieBooking movieBooking) {
		
		movieBooking.setStatus("BOOKED");
		List<MovieBooking> existingBookings = customMovieBookingRepository.searchByMovieIdAndEmailAndDate(movieBooking.getMovie().getId(), 
				movieBooking.getEmail(), movieBooking.getDate());
		
		Integer alreadyBookedSeats = calcuateBookings(existingBookings);
		if (alreadyBookedSeats + movieBooking.getNumber_of_seats() > 10) {
			throw new RuntimeException("Not allowed to book more than 10 tickets per day");
		}
		
		return movieBookingRepository.save(movieBooking);
	}

	@Override
	public List<MovieBooking> findByEmail(String email) {
		
		return movieBookingRepository.findByEmail(email);
	}

	@Override
	public List<MovieBooking> findByKeyAndDateRange(String key, Date fromDate, Date toDate) {
		
		return customMovieBookingRepository.searchByKeyAndDateRange(key, fromDate, toDate);
	}
	
	private Integer calcuateBookings(List<MovieBooking> bookings) {
		Integer count = 0;
		for(MovieBooking movieBooking : bookings) {
			if (movieBooking.getStatus() == null || movieBooking.getStatus().equals("BOOKED")) {
				count = count+movieBooking.getNumber_of_seats();
			}
		}
		return count;
	}

	@Override
	public MovieBooking update(String id, MovieBooking movieBooking) {
		Optional<MovieBooking> existing = movieBookingRepository.findById(id);
		if (existing.isPresent()) {
			MovieBooking existingObj = existing.get();
			existingObj.setDate(movieBooking.getDate());
			existingObj.setNumber_of_seats(movieBooking.getNumber_of_seats());
			
			List<MovieBooking> existingBookings = customMovieBookingRepository.searchByMovieIdAndEmailAndDate(movieBooking.getMovie().getId(), 
					movieBooking.getEmail(), movieBooking.getDate());
			
			Integer alreadyBookedSeats = calcuateBookings(existingBookings);
			if (alreadyBookedSeats + movieBooking.getNumber_of_seats() > 10) {
				throw new RuntimeException("Not allowed to book more than 10 tickets per day");
			}
			
			movieBookingRepository.save(existingObj);
		}
		throw new RuntimeException("Movie Booking not found");
	}

	@Override
	public MovieBooking cancelBooking(String id) {
		Optional<MovieBooking> existingBooking = movieBookingRepository.findById(id);
		if (existingBooking.isPresent()) {
			MovieBooking existingBookingObj = existingBooking.get();
			existingBookingObj.setStatus("CANCELLED");
			return movieBookingRepository.save(existingBookingObj);
		}
		throw new RuntimeException("Movie Booking not found");
		
	}

	@Override
	public Page<MovieBooking> getPagedMovieBookings(PageRequest pageRequest) {
		return movieBookingRepository.findAll(pageRequest);
	}

}
