package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.model.BillModel;
import com.coffee.service.BillService;

@RestController
@RequestMapping("/api")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping("/bill")
	public ResponseEntity<List<BillModel>> getAllBillOfUser(){
		List<BillModel> billModels = billService.getBillOfUser();
		
		return new ResponseEntity<List<BillModel>>(billModels, HttpStatus.OK);
	}
	
	@GetMapping("/bill/on-going")
	public ResponseEntity<List<BillModel>> getAllBillOnGoingOfUser(){
		List<BillModel> billModels = billService.getBillOnGoingOfUser();
		
		return new ResponseEntity<List<BillModel>>(billModels, HttpStatus.OK);
	}
	
	@GetMapping("/bill/complete")
	public ResponseEntity<List<BillModel>> getAllBillCompleteOfUser(){
		List<BillModel> billModels = billService.getBillCompleteOfUser();
		
		return new ResponseEntity<List<BillModel>>(billModels, HttpStatus.OK);
	}
}
