package com.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.entity.Product;
import com.coffee.model.ProductModel;
import com.coffee.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductModel> getAllProducts(){
		List<Product> products = productRepository.findAll();
		List<ProductModel> productModels = new ArrayList<>();
		for(Product product : products) {
			productModels.add(new ProductModel(product));
		}
		return productModels;
	}
	
	public ProductModel getProductModelById(Long id) {
		Product product = productRepository.getById(id);
		return new ProductModel(product);
	}
	
	@Transactional
	public void addProduct(Product product) {
		productRepository.save(product);
	}
}
