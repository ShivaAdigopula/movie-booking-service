package com.albathanext.movie.dto;

import java.util.ArrayList;

public class MovieReviewsResponse {
	public int id;
    public int page;
    public ArrayList<Review> results;
    public int total_pages;
    public int total_results;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public ArrayList<Review> getResults() {
		return results;
	}
	public void setResults(ArrayList<Review> results) {
		this.results = results;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
    
    
}
