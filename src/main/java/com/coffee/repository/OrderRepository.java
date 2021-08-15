package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Order;
import com.coffee.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByUser(User user);
	
	
}
