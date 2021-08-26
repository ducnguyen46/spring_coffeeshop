package com.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coffee.entity.Item;
import com.coffee.model.ItemModel;
import com.coffee.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<ItemModel> getAllItemUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    List<Item> items = itemRepository.getAllItemsOfUser(currentUserName);
		    System.out.println("Items = " + items.size());
		  
		    List<ItemModel> itemModels = new ArrayList<>();
		    for(Item item : items) {
		    	ItemModel itemModel = new ItemModel(item);
		    	itemModels.add(itemModel);
		    }
		    
		    System.out.println("ItemModel = " + itemModels.size());
		    
		    return itemModels;
		}
		return new ArrayList<ItemModel>();
	}
}
