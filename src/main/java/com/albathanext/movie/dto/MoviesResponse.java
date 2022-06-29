package com.albathanext.movie.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class MoviesResponse implements Serializable {
	
	private static final long serialVersionUID = 5277508760669080448L;
	public Long page;
	public ArrayList<Movie> results;
	public Long total_pages;
	public Long total_results;

	
}
