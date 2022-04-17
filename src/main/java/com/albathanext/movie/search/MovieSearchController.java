package com.albathanext.movie.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MovieReviewsResponse;
import com.albathanext.movie.dto.MoviesResponse;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path="/movies")
public class MovieSearchController {
	@Autowired
	private MovieSearchService movieSearchService;
	@GetMapping
	@Operation(summary="Retrieves Featured Movies")
	public MoviesResponse getFeaturedMovies() {
		return movieSearchService.getFeaturedMovies();
	}
	
	@GetMapping("/search")
	@Operation(summary="Search Movies by Query")
	public MoviesResponse searchMovies(@RequestParam(value = "query", required=true) String query) {
		return movieSearchService.searchMovies(query);
	}
	
	@GetMapping("/{movieId}")
	@Operation(summary="Get Movie Details")
	public MovieDetails getMovieDetails(@PathVariable("movieId") Long movieId) {
		return movieSearchService.getMovieDetails(movieId);
	}
	
	@GetMapping("/{movieId}/reviews")
	@Operation(summary="Get Movie Reviews")
	public MovieReviewsResponse getMovieReviews(@PathVariable("movieId") Long movieId, @RequestParam(value = "page", required=false, defaultValue="1") Integer page) {
		return movieSearchService.getMovieReviews(movieId, page);
	}
}
