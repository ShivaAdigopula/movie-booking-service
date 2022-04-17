package com.albathanext.movie.dto;

import java.io.Serializable;
import java.util.ArrayList;


public class MovieDetails implements Serializable{
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 641593466137500415L;
		public Boolean adult;
	    public String backdrop_path;
	    public Object belongs_to_collection;
	    public Double budget;
	    public ArrayList<Genre> genres;
	    public String homepage;
	    public Long id;
	    public String imdb_id;
	    public String original_language;
	    public String original_title;
	    public String overview;
	    public Double popularity;
	    public Object poster_path;
	    public ArrayList<ProductionCompany> production_companies;
	    public ArrayList<ProductionCountry> production_countries;
	    public String release_date;
	    public Long revenue;
	    public Integer runtime;
	    public ArrayList<SpokenLanguage> spoken_languages;
	    public String status;
	    public String tagline;
	    public String title;
	    public Boolean video;
	    public Double vote_average;
	    public Integer vote_count;
		public Boolean getAdult() {
			return adult;
		}
		public void setAdult(Boolean adult) {
			this.adult = adult;
		}
		public String getBackdrop_path() {
			return backdrop_path;
		}
		public void setBackdrop_path(String backdrop_path) {
			this.backdrop_path = backdrop_path;
		}
		public Object getBelongs_to_collection() {
			return belongs_to_collection;
		}
		public void setBelongs_to_collection(Object belongs_to_collection) {
			this.belongs_to_collection = belongs_to_collection;
		}
		public Double getBudget() {
			return budget;
		}
		public void setBudget(Double budget) {
			this.budget = budget;
		}
		public ArrayList<Genre> getGenres() {
			return genres;
		}
		public void setGenres(ArrayList<Genre> genres) {
			this.genres = genres;
		}
		public String getHomepage() {
			return homepage;
		}
		public void setHomepage(String homepage) {
			this.homepage = homepage;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getImdb_id() {
			return imdb_id;
		}
		public void setImdb_id(String imdb_id) {
			this.imdb_id = imdb_id;
		}
		public String getOriginal_language() {
			return original_language;
		}
		public void setOriginal_language(String original_language) {
			this.original_language = original_language;
		}
		public String getOriginal_title() {
			return original_title;
		}
		public void setOriginal_title(String original_title) {
			this.original_title = original_title;
		}
		public String getOverview() {
			return overview;
		}
		public void setOverview(String overview) {
			this.overview = overview;
		}
		public Double getPopularity() {
			return popularity;
		}
		public void setPopularity(Double popularity) {
			this.popularity = popularity;
		}
		public Object getPoster_path() {
			return poster_path;
		}
		public void setPoster_path(Object poster_path) {
			this.poster_path = poster_path;
		}
		public ArrayList<ProductionCompany> getProduction_companies() {
			return production_companies;
		}
		public void setProduction_companies(ArrayList<ProductionCompany> production_companies) {
			this.production_companies = production_companies;
		}
		public ArrayList<ProductionCountry> getProduction_countries() {
			return production_countries;
		}
		public void setProduction_countries(ArrayList<ProductionCountry> production_countries) {
			this.production_countries = production_countries;
		}
		public String getRelease_date() {
			return release_date;
		}
		public void setRelease_date(String release_date) {
			this.release_date = release_date;
		}
		public Long getRevenue() {
			return revenue;
		}
		public void setRevenue(Long revenue) {
			this.revenue = revenue;
		}
		public Integer getRuntime() {
			return runtime;
		}
		public void setRuntime(Integer runtime) {
			this.runtime = runtime;
		}
		public ArrayList<SpokenLanguage> getSpoken_languages() {
			return spoken_languages;
		}
		public void setSpoken_languages(ArrayList<SpokenLanguage> spoken_languages) {
			this.spoken_languages = spoken_languages;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTagline() {
			return tagline;
		}
		public void setTagline(String tagline) {
			this.tagline = tagline;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Boolean getVideo() {
			return video;
		}
		public void setVideo(Boolean video) {
			this.video = video;
		}
		public Double getVote_average() {
			return vote_average;
		}
		public void setVote_average(Double vote_average) {
			this.vote_average = vote_average;
		}
		public Integer getVote_count() {
			return vote_count;
		}
		public void setVote_count(Integer vote_count) {
			this.vote_count = vote_count;
		}
	    
	    
	    
	    
	    
	    
	    
	    
}
