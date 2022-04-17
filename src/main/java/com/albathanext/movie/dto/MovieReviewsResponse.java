package com.albathanext.movie.dto;

import java.util.ArrayList;

public class MovieReviewsResponse {
	public Long id;
    public Integer page;
    public ArrayList<Review> results;
    public Integer total_pages;
    public Integer total_results;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public ArrayList<Review> getResults() {
		return results;
	}
	public void setResults(ArrayList<Review> results) {
		this.results = results;
	}
	public Integer getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}
	public Integer getTotal_results() {
		return total_results;
	}
	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}
	
    
    
    
}
