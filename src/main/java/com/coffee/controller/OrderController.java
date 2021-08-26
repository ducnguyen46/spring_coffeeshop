package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.dto.OrderDto;
import com.coffee.dto.ResponseDto;
import com.coffee.model.OrderModel;
import com.coffee.service.OrderService;
import com.coffee.service.ShipmentService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@GetMapping("/order")
	public ResponseEntity<List<OrderModel>> getAllOrderOfUser(){
		List<OrderModel> orderModels = orderService.getAllOrders();
		
		return new ResponseEntity<List<OrderModel>>(orderModels, HttpStatus.OK);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto){
		boolean result = orderService.createOrder(orderDto);
		
		if(!result) {
			return new ResponseEntity<Object>(result, HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
	
	@PutMapping("/order-received/{id}")
	public ResponseEntity<?> completeOrder(@PathVariable(value = "id") Long id){
		int result = shipmentService.completeOrder(id);
		if(result != 0) {
			return new ResponseEntity<ResponseDto>(new ResponseDto("OK", "Completed"), HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto("ERROR", "Update fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
