package com.albathanext.movie.booking;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albathanext.movie.model.MovieBooking;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path="/movies/booking")
public class MovieBookingController {
	@Autowired
	private MovieBookingService movieBookingService;
	
	@PostMapping
	@Operation(summary="Create Movie Booking")
	public ResponseEntity<MovieBooking> createBooking(@RequestBody MovieBooking movieBooking) {
		return new ResponseEntity<MovieBooking>(movieBookingService.save(movieBooking), HttpStatus.CREATED);
	}
	
	@GetMapping("/search")
	@Operation(summary="Search Movie Bookings")
	public List<MovieBooking> searchByEmailAndDateRange(@RequestParam(value = "key", required=false) String searchKey, 
			@RequestParam(value = "fromDate", required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date fromDate,
			@RequestParam(value = "toDate", required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date toDate){
		return movieBookingService.findByKeyAndDateRange(searchKey, fromDate, toDate);
	}
	
	@PutMapping("/{id}")
	@Operation(summary="Update Movie Booking")
	public MovieBooking updateBooking(@PathVariable("id") String id, @RequestBody MovieBooking movieBooking) {
		return movieBookingService.update(id, movieBooking);
	}
	
	@PutMapping("/cancel/{id}")
	@Operation(summary="Cancel Movie Booking")
	public MovieBooking updateBooking(@PathVariable("id") String id) {
		return movieBookingService.cancelBooking(id);
	}

}

