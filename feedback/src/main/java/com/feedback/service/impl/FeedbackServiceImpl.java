package com.feedback.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDAO;
import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDAO dao;
	
	@Override
	public Feedback createFeedback(Feedback feedback) throws BusinessException {
		return dao.save(feedback);
	}

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException {
		Feedback feedback = null;
		try {
		feedback = dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for this ID");
		}
		return feedback;
	}

	@Override
	public Feedback getFeedbackByName(String name) throws BusinessException {
		Feedback feedback = null;
		try {
		feedback = dao.findByName(name);
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for this name");
		}
		return feedback;
	}

	@Override
	public void deleteFeedback(int id) throws BusinessException {
		
		if(id <= 0) {
			throw new BusinessException("Invalid ID");
		}
		
		try {
		dao.deleteById(id);
		} catch (NoSuchElementException e) {
			throw new BusinessException("No feedback for this ID");
		}
	}

	@Override
	public List<Feedback> getFeedbacks() {
		
		
		return dao.findAll();
	}

}
