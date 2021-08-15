package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.dto.OrderDto;
import com.coffee.model.OrderModel;
import com.coffee.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public ResponseEntity<List<OrderModel>> getAllOrderOfUser(){
		List<OrderModel> orderModels = orderService.getAllOrders();
		
		return new ResponseEntity<List<OrderModel>>(orderModels, HttpStatus.OK);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Object> createOrder(OrderDto orderDto){
		boolean result = orderService.createOrder(orderDto);
		
		if(!result) {
			return new ResponseEntity<Object>(result, HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
}
