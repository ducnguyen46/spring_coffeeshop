package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Feedback;
import com.coffee.entity.Order;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	List<Feedback> findByOrder(Order order);
	
}
