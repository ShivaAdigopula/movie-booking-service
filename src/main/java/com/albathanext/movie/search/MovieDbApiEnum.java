package com.albathanext.movie.search;

public enum MovieDbApiEnum {
	MOVIE_DB_API_VERSION("3"), DISOVER_MOVIES_PATH("/discover/movie"), SEARCH_MOVIE_PATH("/search/movie"), MOVIE_DETAILS_PATH("/movie/"),
	REVIEWS("/reviews");

	public final String value;

	private MovieDbApiEnum(String value) {
		this.value = value;
	};

	@Override
	public String toString() {
		return this.value;
	}

}
