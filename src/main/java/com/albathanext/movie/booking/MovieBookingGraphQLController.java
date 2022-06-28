package com.albathanext.movie.booking;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.albathanext.movie.model.MovieBooking;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MovieBookingGraphQLController {
	
	private MovieBookingService movieBookingService;
	
	@MutationMapping
	public MovieBooking createBooking(@Argument MovieBooking movieBooking) {
		return movieBookingService.save(movieBooking);	
	}
	

	
}
