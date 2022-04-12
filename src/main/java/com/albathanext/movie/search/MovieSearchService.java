package com.albathanext.movie.search;

import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MoviesResponse;

public interface MovieSearchService {
	MoviesResponse getFeaturedMovies();
	MoviesResponse searchMovies(String query);
	MovieDetails getMovieDetails(Long movieId);
}
