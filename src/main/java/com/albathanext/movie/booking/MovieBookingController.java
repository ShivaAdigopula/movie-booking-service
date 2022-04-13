package com.albathanext.movie.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albathanext.movie.model.MovieBooking;

@RestController
@RequestMapping(path="/movies/booking")
public class MovieBookingController {
	@Autowired
	private MovieBookingService movieBookingService;
	
	@PostMapping
	public MovieBooking createBooking(@RequestBody MovieBooking movieBooking) {
		return movieBookingService.save(movieBooking);
	}
	
	@GetMapping
	public List<MovieBooking> searchByEmail(@RequestParam(value = "email", required=true) String email){
		return movieBookingService.findByEmail(email);
	}
	

}

