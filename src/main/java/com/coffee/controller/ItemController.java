package com.coffee.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.model.ItemModel;
import com.coffee.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public ResponseEntity<?> getAllItemOfUser(){
		ArrayList<ItemModel> itemModels = new ArrayList<>(itemService.getAllItemUser());
		return new ResponseEntity<ArrayList<ItemModel>>(itemModels, HttpStatus.OK);
	}
}
