package com.coffee.model;

import com.coffee.entity.Category;

public class CategoryModel {
	
	public CategoryModel(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}
	
	public CategoryModel() {
		// TODO Auto-generated constructor stub
	}
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
