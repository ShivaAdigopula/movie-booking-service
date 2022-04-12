package com.albathanext.movie.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MoviesResponse;

@RestController
@RequestMapping(path="/movies")
public class MovieSearchController {
	@Autowired
	private MovieSearchService movieSearchService;
	@GetMapping
	public MoviesResponse getFeaturedMovies() {
		return movieSearchService.getFeaturedMovies();
	}
	
	@GetMapping("/search")
	public MoviesResponse searchMovies(@RequestParam(value = "query", required=true) String query) {
		return movieSearchService.searchMovies(query);
	}
	
	@GetMapping("/{movieId}")
	public MovieDetails getMovieDetails(@PathVariable("movieId") Long movieId) {
		return movieSearchService.getMovieDetails(movieId);
	}
}
