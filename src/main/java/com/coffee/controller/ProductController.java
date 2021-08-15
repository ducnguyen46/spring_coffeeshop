package com.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.entity.Product;
import com.coffee.model.ProductModel;
import com.coffee.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService  productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getAllProduct(){
		ArrayList<ProductModel> productModels = new ArrayList<ProductModel>();
		productModels.addAll(productService.getAllProducts());
		return new ResponseEntity<List<ProductModel>>(productModels, HttpStatus.OK);
	}
	
	@GetMapping("product/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable("id") Long id){
		ProductModel productModel = productService.getProductModelById(id);
		
		return new ResponseEntity<ProductModel>(productModel, HttpStatus.OK);
	}
	
	
}
