package com.albathanext.movie.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MovieReviewsResponse;
import com.albathanext.movie.dto.MoviesResponse;
import com.albathanext.movie.search.MovieSearchService;

@Controller
public class MovieQuery {
	@Autowired
	private MovieSearchService movieSearchService;
	
	@QueryMapping
	public MoviesResponse queryFeaturedMovies(@Argument Long page) {
		return movieSearchService.getFeaturedMovies(page);
	}
	
	@QueryMapping
	public MovieDetails queryMovieDetails(@Argument Long movieId) {
		return movieSearchService.getMovieDetails(movieId);
	}
	
	@QueryMapping
	public MovieReviewsResponse queryReviews(@Argument Long movieId, @Argument Integer page) {
		return movieSearchService.getMovieReviews(movieId, page);
	}
	
	
	
}
