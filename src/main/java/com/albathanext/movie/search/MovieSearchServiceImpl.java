package com.albathanext.movie.search;

import static com.albathanext.movie.search.MovieDbApiEnum.DISOVER_MOVIES_PATH;
import static com.albathanext.movie.search.MovieDbApiEnum.MOVIE_DB_API_VERSION;
import static com.albathanext.movie.search.MovieDbApiEnum.MOVIE_DETAILS_PATH;
import static com.albathanext.movie.search.MovieDbApiEnum.REVIEWS;
import static com.albathanext.movie.search.MovieDbApiEnum.SEARCH_MOVIE_PATH;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MovieReviewsResponse;
import com.albathanext.movie.dto.MoviesResponse;

@Service
public class MovieSearchServiceImpl implements MovieSearchService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MovieSearchServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${movie.db.url}")
	private String movieDbUrl;
	
	@Value("${movie.db.api.key}")
	private String movieDbApiKey;

	@Cacheable(
			value = "featuredMoviesCache",
			key = "#page", unless="#result == null")
	@Override
	public MoviesResponse getFeaturedMovies(Long page) {
		URIBuilder builder = getMovieDBURIBuilder();
		if ( builder == null) {
			throw new RuntimeException("Invalid Movie DB URL configured");
		}
		
		builder.setPath("/".concat(MOVIE_DB_API_VERSION.toString()).concat(DISOVER_MOVIES_PATH.toString()));
		builder.addParameter("api_key", movieDbApiKey);
		builder.addParameter("language", "en-US");
		builder.addParameter("sort_by", "popularity.desc");
		builder.addParameter("include_adult", "false");
		builder.addParameter("page", page == null ? "1": page.toString());
		return restTemplate.getForObject(
				builder.toString(),
				MoviesResponse.class);
	}
	
	@Override
	public MoviesResponse searchMovies(String query, Long page) {
		URIBuilder builder = getMovieDBURIBuilder();
		if ( builder == null) {
			throw new RuntimeException("Invalid Movie DB URL configured");
		}
		
		builder.setPath("/".concat(MOVIE_DB_API_VERSION.toString()).concat(SEARCH_MOVIE_PATH.toString()));
		builder.addParameter("api_key", movieDbApiKey);
		builder.addParameter("language", "en-US");
		builder.addParameter("query", query);
		builder.addParameter("include_adult", "false");
		builder.addParameter("page", page == null ? "1": page.toString());
		return restTemplate.getForObject(
				builder.toString(),
				MoviesResponse.class);
	}
	
	private URIBuilder getMovieDBURIBuilder() {
		URIBuilder builder;
		try {
			return new URIBuilder(movieDbUrl);
		} catch (URISyntaxException e) {
			LOGGER.error("The Movie DB URI is invalid");
		}
		return null;
	}

	@Override
	public MovieDetails getMovieDetails(Long movieId) {
		URIBuilder builder = getMovieDBURIBuilder();
		if ( builder == null) {
			throw new RuntimeException("Invalid Movie DB URL configured");
		}
		
		if (movieId == null) {
			throw new RuntimeException("Movie ID is required");
		}
		
		builder.setPath("/".concat(MOVIE_DB_API_VERSION.toString()).concat(MOVIE_DETAILS_PATH.toString()).concat(movieId.toString()));
		builder.addParameter("api_key", movieDbApiKey);
		builder.addParameter("language", "en-US");
		return restTemplate.getForObject(
				builder.toString(),
				MovieDetails.class);
	}
	
	
	@Override
	public MovieReviewsResponse getMovieReviews(Long movieId, Integer page) {
		URIBuilder builder = getMovieDBURIBuilder();
		if ( builder == null) {
			throw new RuntimeException("Invalid Movie DB URL configured");
		}
		
		if (movieId == null) {
			throw new RuntimeException("Movie ID is required");
		}
		
		builder.setPath("/".concat(MOVIE_DB_API_VERSION.toString()).concat(MOVIE_DETAILS_PATH.toString()).concat(movieId.toString()).concat(REVIEWS.toString()));
		builder.addParameter("api_key", movieDbApiKey);
		builder.addParameter("language", "en-US");
		return restTemplate.getForObject(
				builder.toString(),
				MovieReviewsResponse.class);
	}

}
