package com.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coffee.entity.Bill;
import com.coffee.model.BillModel;
import com.coffee.repository.BillRepository;

@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	public List<BillModel> getBillOfUser(){
		List<BillModel> billModels = new ArrayList<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    
		    List<Bill> bills = billRepository.findByUser(currentUserName);
		    for(Bill bill : bills) {
		    	billModels.add(new BillModel(bill));
		    }
		}
		
		return billModels;
	}
}
