package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@RestController
public class FeedbackController{

	@Autowired
	private FeedbackService service;
	private MultiValueMap<String, String> map;

	@PostMapping("/feedback")
	public Feedback createFeedback(@RequestBody Feedback feedback) throws BusinessException {
		return service.createFeedback(feedback);
	}

	@GetMapping("/feedback/id/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) throws BusinessException {
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/feedback/name/{name}")
	public ResponseEntity<Feedback> getFeedbackByName(@PathVariable("name") String name) throws BusinessException {
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackByName(name),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/feedback/delete/{id}")
	public ResponseEntity<Feedback> deleteFeedback(@PathVariable("id") int id) throws BusinessException {
		try {
			service.deleteFeedback(id);
			return new ResponseEntity<Feedback>(HttpStatus.OK);
		} catch (BusinessException e) {
			map = new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null, map, HttpStatus.NOT_FOUND);

		}
		
	}

	@GetMapping(("/feedbacks"))
	public List<Feedback> getFeedbacks() {
		return service.getFeedbacks();
	}
}
