package com.albathanext.movie.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MovieDetails extends Movie {

	public Object belongs_to_collection;
	public Double budget;
	public ArrayList<Genre> genres;
	public String homepage;

	public String imdb_id;

	public ArrayList<ProductionCompany> production_companies;
	public ArrayList<ProductionCountry> production_countries;

	public Long revenue;
	public Integer runtime;
	public ArrayList<SpokenLanguage> spoken_languages;
	public String status;
	public String tagline;
	public List<Review> reviews;

}
