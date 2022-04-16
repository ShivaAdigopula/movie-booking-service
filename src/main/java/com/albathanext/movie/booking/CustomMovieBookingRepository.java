package com.albathanext.movie.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.albathanext.movie.model.MovieBooking;

import io.micrometer.core.instrument.util.StringUtils;

@Repository
public class CustomMovieBookingRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<MovieBooking> searchByKeyAndDateRange(String key, Date fromDate, Date toDate) {
		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<>();
		if (StringUtils.isNotBlank(key)) {
			criteria.add(new Criteria().orOperator(Criteria.where("email").regex(key),
					Criteria.where("first_name").regex(key), Criteria.where("last_name").regex(key)));
		}
		if (fromDate != null) {
			criteria.add(Criteria.where("date").gte(fromDate));
		}

		if (toDate != null) {
			criteria.add(Criteria.where("date").lte(toDate));
		}

		if (!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		}

		return mongoTemplate.find(query, MovieBooking.class);
	}

	public List<MovieBooking> searchByMovieIdAndEmailAndDate(Long movie_id, String email, String date) {
		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<>();
		if (StringUtils.isNotBlank(email)) {
			criteria.add(Criteria.where("email").is(email));
		}

		if (movie_id != null) {
			criteria.add(Criteria.where("movie.id").is(movie_id));
		}

		if (date != null) {
			criteria.add(Criteria.where("date").is(date));
		}

		if (!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		}

		return mongoTemplate.find(query, MovieBooking.class);
	}

}
