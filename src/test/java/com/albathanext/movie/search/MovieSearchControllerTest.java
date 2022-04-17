package com.albathanext.movie.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.albathanext.movie.dto.Movie;
import com.albathanext.movie.dto.MovieDetails;
import com.albathanext.movie.dto.MovieReviewsResponse;
import com.albathanext.movie.dto.MoviesResponse;
import com.albathanext.movie.dto.Review;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieSearchControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieSearchService movieSearchService;
	
	@Test
	public void getFeaturedMoviesShouldReturnResults() throws Exception {
		
		MoviesResponse mockResponse = getMockResponse();
		ObjectMapper obj = new ObjectMapper();
		String response = obj.writeValueAsString(mockResponse);
		
		when(movieSearchService.getFeaturedMovies()).thenReturn(mockResponse);
		MvcResult mvcResult = this.mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isOk()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(response, content);
		
	}
	
	@Test
	public void searchMoviesShouldReturnResults() throws Exception {
		
		MoviesResponse mockResponse = getMockResponse();
		ObjectMapper obj = new ObjectMapper();
		String response = obj.writeValueAsString(mockResponse);
		
		when(movieSearchService.searchMovies("Test")).thenReturn(mockResponse);
		MvcResult mvcResult = this.mockMvc.perform(get("/movies/search?query=Test")).andDo(print()).andExpect(status().isOk()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(response, content);
		
	}
	
	@Test
	public void searchMoviesShouldThrowException() throws Exception {
		
		MoviesResponse mockResponse = getMockResponse();
		ObjectMapper obj = new ObjectMapper();
		String response = obj.writeValueAsString(mockResponse);
		
		when(movieSearchService.searchMovies("Test")).thenReturn(mockResponse);
		MvcResult mvcResult = this.mockMvc.perform(get("/movies/search")).andDo(print()).andExpect(status().is5xxServerError()).andReturn();
	}
	
	@Test
	public void getMovieDetailsShouldReturnResults() throws Exception {
		
		MovieDetails mockResponse = getMovieDetails();
		ObjectMapper obj = new ObjectMapper();
		String response = obj.writeValueAsString(mockResponse);
		
		when(movieSearchService.getMovieDetails(1L)).thenReturn(mockResponse);
		MvcResult mvcResult = this.mockMvc.perform(get("/movies/1")).andDo(print()).andExpect(status().isOk()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(response, content);
		
	}
	
	@Test
	public void getMovieReviewsShouldReturnResults() throws Exception {
		
		MovieReviewsResponse mockResponse = getMovieReviewsResponse();
		ObjectMapper obj = new ObjectMapper();
		String response = obj.writeValueAsString(mockResponse);
		
		when(movieSearchService.getMovieReviews(1L, 1)).thenReturn(mockResponse);
		MvcResult mvcResult = this.mockMvc.perform(get("/movies/1/reviews?page=1")).andDo(print()).andExpect(status().isOk()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(response, content);
		
	}
	
	private MovieReviewsResponse getMovieReviewsResponse() {
		Review review1 = new Review();
		review1.setAuthor("tester");
		review1.setContent("test test test");
		review1.setId("1");
		review1.setUrl("testurl.com");
		ArrayList<Review> reviews = new ArrayList();
		reviews.add(review1);
		
		MovieReviewsResponse movieReviewResponse = new MovieReviewsResponse();
		movieReviewResponse.setId(1L);
		movieReviewResponse.setPage(1);
		movieReviewResponse.setResults(reviews);
		return movieReviewResponse;
	}
	
	
	private MovieDetails getMovieDetails() {
		MovieDetails movieDetails = new MovieDetails();
		movieDetails.setAdult(false);
		movieDetails.setId(1L);
		movieDetails.setTitle("Test 1");
		movieDetails.setOverview("test test test test");
		return movieDetails;
	}
	
	
	private MoviesResponse getMockResponse() {
		Movie movie1 = new Movie();
		movie1.setAdult(false);
		movie1.setId(1L);
		movie1.setOriginal_language("use-en");
		movie1.setPopularity(1000D);
		movie1.setTitle("Test 1");
		movie1.setRelease_date("17-04-2022");
		movie1.setVote_average(8.7);
		
		ArrayList<Movie> result = new ArrayList<Movie>();
		result.add(movie1);
		
		MoviesResponse mockResponse = new MoviesResponse();
		mockResponse.setPage(1);
		mockResponse.setTotal_pages(10);
		mockResponse.setTotal_results(100);
		mockResponse.setResults(result);
		return mockResponse;
	};
	

}
