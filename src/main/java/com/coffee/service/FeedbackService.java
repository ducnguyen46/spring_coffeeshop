package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.dto.FeedbackDto;
import com.coffee.entity.Feedback;
import com.coffee.entity.Order;
import com.coffee.model.FeedbackModel;
import com.coffee.repository.FeedbackRepository;
import com.coffee.repository.OrderRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional
	public boolean addFeedbackOrder(FeedbackDto feedbackDto) {
		Order order = orderRepository.getById(feedbackDto.getOrderId());
		
		Feedback feedback = new Feedback();
		feedback.setTitle(feedbackDto.getTitle());
		feedback.setContent(feedbackDto.getContent());
		feedback.setOrder(order);
		
		Feedback feedbackSaved = feedbackRepository.save(feedback);
		if(feedbackSaved != null) {
			return true;
		}
		return false;
	}
	
//	public FeedbackDto getFeedbackOrder() {
//		
//	}
	
}
