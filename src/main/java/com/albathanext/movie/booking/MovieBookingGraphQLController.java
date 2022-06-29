package com.albathanext.movie.booking;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
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
	
	@MutationMapping
	public MovieBooking cancelBooking(@Argument String bookingId) {
		return movieBookingService.cancelBooking(bookingId);
	}
	
	@SchemaMapping(typeName="Query", value="movieBookings")
	public List<MovieBooking> getMovieBookings() {
		return movieBookingService.findByKeyAndDateRange(null, null, null);
	}
	

	
}
							