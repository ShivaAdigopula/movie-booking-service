package com.albathanext.movie.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.albathanext.movie.model.Movie;
import com.albathanext.movie.model.MovieBooking;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class MovieBookingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MovieBookingService movieBookingService;

	@Test
	void createreateBookingReturnsResults() throws Exception{
		MovieBooking request = getMovieBooking();
		request.setId(null);
		
		MovieBooking response = getMovieBooking();
		response.setId("1L"); 
		response.setStatus("Booked");
		
		Mockito.when(movieBookingService.save(Mockito.any(MovieBooking.class))).thenReturn(response);
		
		ObjectMapper obj = new ObjectMapper();
		
		String requestStr = obj.writeValueAsString(request);
		String responseStr = obj.writeValueAsString(response);
		
		MvcResult result = this.mockMvc.perform(post("/movies/booking").content(requestStr)
				.contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated()).andDo(print()).andReturn();
		
		assertEquals(responseStr, result.getResponse().getContentAsString());
			     
			      
	}

	@Test
	void searchByEmailAndDateRangeReturnResults() throws Exception{
		
		
		MovieBooking movieBooking1 = getMovieBooking();
		// response.setId("1L"); 
		List movieBookings = new ArrayList();
		movieBookings.add(movieBooking1);
		
		Mockito.when(movieBookingService.findByKeyAndDateRange(Mockito.anyString(), Mockito.any(Date.class), Mockito.any(Date.class))).thenReturn(movieBookings);
		
		ObjectMapper obj = new ObjectMapper();
		
		String responseStr = obj.writeValueAsString(movieBookings);
		
		MvcResult result = this.mockMvc.perform(get("/movies/booking/search?key=test&fromDate=14-06-2022&toDate=15-08-2022"))
			      .andExpect(status().isOk()).andDo(print()).andReturn();
		
		assertEquals(responseStr, result.getResponse().getContentAsString());
	}

	@Test
	void UpdateMovieBookingReturnResults() throws Exception{
		MovieBooking request = getMovieBooking();
		request.setId("1L");
		
		MovieBooking response = getMovieBooking();
		response.setId("1L"); 
		
		Mockito.when(movieBookingService.update(Mockito.anyString(), Mockito.any(MovieBooking.class))).thenReturn(response);
		
		ObjectMapper obj = new ObjectMapper();
		
		String requestStr = obj.writeValueAsString(request);
		String responseStr = obj.writeValueAsString(response);
		
		MvcResult result = this.mockMvc.perform(put("/movies/booking/1").content(requestStr)
				.contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk()).andDo(print()).andReturn();
		assertEquals(responseStr, result.getResponse().getContentAsString());
	}

	@Test
	void cancelBookingReturnResults() throws Exception{
		MovieBooking request = getMovieBooking();
		request.setId("1L");
		request.setStatus("BOOKED");
		
		MovieBooking response = getMovieBooking();
		response.setId("1L"); 
		response.setStatus("CANCELLED");
		
		Mockito.when(movieBookingService.cancelBooking(Mockito.anyString())).thenReturn(response);
		
		ObjectMapper obj = new ObjectMapper();
		
		String requestStr = obj.writeValueAsString(request);
		String responseStr = obj.writeValueAsString(response);
		
		MvcResult result = this.mockMvc.perform(put("/movies/booking/cancel/1"))
			      .andExpect(status().isOk()).andDo(print()).andReturn();
		assertEquals(responseStr, result.getResponse().getContentAsString());
	}
	
	private MovieBooking getMovieBooking() {
		Movie movie = new Movie();
		movie.setId(1L);
		movie.setTitle("Test Movie");
		movie.setPoster_path("test path");
		MovieBooking movieBooking = new MovieBooking();
		movieBooking.setId("id");
		movieBooking.setEmail("tester@gmail.com");
		movieBooking.setNumber_of_seats(10);
		movieBooking.setMovie(movie);
		movieBooking.setDate("16-04-2022");
		movieBooking.setFirst_name("first_name");
		movieBooking.setLast_name("last_name");
		// movieBooking.setStatus(status);
		
		return movieBooking;
	}

}
