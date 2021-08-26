package com.coffee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coffee.entity.Order;
import com.coffee.entity.User;
import com.coffee.repository.OrderRepository;
import com.coffee.repository.ShipmentRepository;
import com.coffee.repository.UserRepository;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
@Autowired 
private UserRepository userRepository;

@Autowired
private OrderRepository orderRepository;
	
	public int completeOrder(Long orderId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			User user = userRepository.getUserByUsername(currentUserName).get(0);

			Optional<Order> optionalOrder = orderRepository.findById(orderId);
			if (optionalOrder.isPresent()) {
				Order completeOrder = optionalOrder.get();
				if (completeOrder.getUser().getId() == user.getId()) {
					return shipmentRepository.orderCompleted(orderId);
				}
			}
		}
		return 0;
	}
}
