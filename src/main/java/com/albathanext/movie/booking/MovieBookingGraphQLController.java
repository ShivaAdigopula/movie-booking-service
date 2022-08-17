package com.albathanext.movie.booking;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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
	public Iterable<MovieBooking> getMovieBookings() {
		return movieBookingService.findByKeyAndDateRange(null, null, null);
	}
	
	@SchemaMapping(typeName="Query", value="pageMovieBookings")
	public Page<MovieBooking> getPagedMovieBookings(@Argument @DefaultValue(value="1") Integer page, @Argument @DefaultValue(value="10") Integer size){
		final PageRequest pageRequest = PageRequest.of(page, size);
		return movieBookingService.getPagedMovieBookings(pageRequest);
	}
	

	
}
							