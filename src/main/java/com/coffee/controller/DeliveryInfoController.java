package com.coffee.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.dto.ResponseDto;
import com.coffee.model.DeliveryInfoModel;
import com.coffee.service.DeliveryInfoService;

@RestController
@RequestMapping("/api")
public class DeliveryInfoController {

	@Autowired
	private DeliveryInfoService deliveryInfoService;
	
	@PostMapping("/delivery-info")
	public ResponseEntity<?> addNewDeliveryInfo(@RequestBody DeliveryInfoModel deliveryInfoModel){
		boolean result = deliveryInfoService.addDeliveryInfo(deliveryInfoModel);
		if(result) {
			return new ResponseEntity<ResponseDto>(new ResponseDto("OK", "Add new successful"), HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto("ERROR", "Add fail"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/delivery-info")
	public ResponseEntity<?> getDeliveryInfoOfUser(){
		ArrayList<DeliveryInfoModel> deliveryInfoModels = new ArrayList<DeliveryInfoModel>(deliveryInfoService.getDeliveryInfoOfUser());
		
		return new ResponseEntity<ArrayList<DeliveryInfoModel>>(deliveryInfoModels, HttpStatus.OK);
	}
	
	@PutMapping("/delivery-info")
	public ResponseEntity<?> deleteDeliveryInfo(@RequestBody DeliveryInfoModel deliveryInfoModel){
		boolean result = deliveryInfoService.deleteDeliveryInfo(deliveryInfoModel);
		if(result) {
			return new ResponseEntity<ResponseDto>(new ResponseDto("OK", "Deletd successful"), HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto("ERROR", "Delete fail"), HttpStatus.OK);
		}
	}
	
}
