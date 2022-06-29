package com.albathanext.movie.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Review {
	public String author;
    public AuthorDetails author_details;
    public String content;
    public Date created_at;
    public String id;
    public Date updated_at;
    public String url;
}
