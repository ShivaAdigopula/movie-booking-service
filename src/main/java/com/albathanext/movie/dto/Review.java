package com.albathanext.movie.dto;

import java.util.Date;

public class Review {
	public String author;
    public AuthorDetails author_details;
    public String content;
    public Date created_at;
    public String id;
    public Date updated_at;
    public String url;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public AuthorDetails getAuthor_details() {
		return author_details;
	}
	public void setAuthor_details(AuthorDetails author_details) {
		this.author_details = author_details;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
    
}
