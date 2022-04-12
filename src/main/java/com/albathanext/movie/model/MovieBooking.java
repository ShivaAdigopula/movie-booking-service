package com.albathanext.movie.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document("movieBooking")
public class MovieBooking {
	 @Id
     private String id;

     private String first_name;
     private String last_name;
     private String email;
     private Integer number_of_seats;
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
     private Date date;
     private Long movie_id;
     private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getNumber_of_seats() {
		return number_of_seats;
	}
	public void setNumber_of_seats(Integer number_of_seats) {
		this.number_of_seats = number_of_seats;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
     
     
}
