package com.albathanext.movie.search;

import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MovieReviewsResponse;
import com.albathanext.movie.dto.MoviesResponse;

public interface MovieSearchService {
	MoviesResponse getFeaturedMovies(Long page);
	MoviesResponse searchMovies(String query);
	MovieDetails getMovieDetails(Long movieId);
	MovieReviewsResponse getMovieReviews(Long movieId, Integer page);
}
