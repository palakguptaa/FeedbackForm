package com.feedback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.model.Feedback;

@Repository
public interface FeedbackDAO extends JpaRepository<Feedback, Integer> {

	public Feedback findByName(String name);
	

}
