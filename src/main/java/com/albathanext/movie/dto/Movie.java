package com.albathanext.movie.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Movie {
	public Boolean adult;
    public String backdrop_path;
    public ArrayList<Integer> genre_ids;
    public Long id;
    public String original_language;
    public String original_title;
    public String overview;
    public Double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public Boolean video;
    public Double vote_average;
    public Integer vote_count;    
}
