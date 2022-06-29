package com.albathanext.movie.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MovieReviewsResponse;
import com.albathanext.movie.dto.MoviesResponse;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MovieGraphQLController {
	@Autowired
	private MovieSearchService movieSearchService;
	
	@SchemaMapping(typeName="Query", value="featuredMovies")
	public MoviesResponse getFeaturedMovies(@Argument Long page) {
		return movieSearchService.getFeaturedMovies(page);
	}
	
	@SchemaMapping(typeName="Query", value="movieDetails")
	public MovieDetails getMovieDetails(@Argument Long movieId) {
		log.info("getMovieDetails with {}", movieId);
		return movieSearchService.getMovieDetails(movieId);
	}
	
	@SchemaMapping(typeName="Query", value="reviewsForMovie")
	public MovieReviewsResponse getReviews(@Argument Long movieId, @Argument Integer page) {
		return movieSearchService.getMovieReviews(movieId, page);
	}
	
	@SchemaMapping(typeName="Query", value="movies")
	public MoviesResponse searchMovies(@Argument String query, @Argument Long page) {
		return movieSearchService.searchMovies(query, page);
	}
	
	
	
}
