package com.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.entity.DeliveryInfo;
import com.coffee.entity.User;
import com.coffee.model.DeliveryInfoModel;
import com.coffee.repository.DeliveryInfoRepository;
import com.coffee.repository.UserRepository;

@Service
public class DeliveryInfoService {

	@Autowired
	private DeliveryInfoRepository deliveryInfoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public boolean addDeliveryInfo(DeliveryInfoModel deliveryInfoModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    User user = userRepository.getUserByUsername(currentUserName).get(0);
		    
		    DeliveryInfo deliveryInfo = new DeliveryInfo(deliveryInfoModel);
		    deliveryInfo.setUser(user);
			
			DeliveryInfo deliveryInfoSaved = deliveryInfoRepository.save(deliveryInfo);
			
			if(deliveryInfoSaved != null) return true;
		}
		
		return false;
	}
	
	public List<DeliveryInfoModel> getDeliveryInfoOfUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    
		    List<DeliveryInfoModel> deliveryInfoModels = new ArrayList<>();
		    List<DeliveryInfo> deliveryInfos = deliveryInfoRepository.getDeliveryInfoByUsername(currentUserName);
		    
		    System.out.println("Size of list 1 - " + deliveryInfos.size());
		    
		    for(DeliveryInfo deliveryInfo : deliveryInfos) {
		    	DeliveryInfoModel deliveryInfoModel = new DeliveryInfoModel(deliveryInfo);
		    	deliveryInfoModels.add(deliveryInfoModel);
		    }
		    
		    System.out.println("Size of list 2 - " + deliveryInfoModels.size());

		    
		    return deliveryInfoModels;
		}
		return new ArrayList<DeliveryInfoModel>();
	}
	
	public boolean deleteDeliveryInfo(DeliveryInfoModel deliveryInfoModel) {
		boolean result = false;
		
		int delete = deliveryInfoRepository.deleteDeliveryInfo(deliveryInfoModel.getId());
		if(delete != 0) {
			result = true;
		}
		
		return result;
	}
	
}
