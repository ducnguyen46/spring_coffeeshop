package com.coffee.converter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coffee.entity.Role;
import com.coffee.entity.User;
import com.coffee.model.UserModel;
import com.coffee.repository.DeliveryInfoRepository;
import com.coffee.repository.UserRepository;

public class DtoEntityConverter {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DeliveryInfoRepository deliveryInfoRepository;
	
	public User UserDtoEntity(UserModel dto) {
		User user = new User();
		
		user.setId(dto.getId());
		user.setFullName(dto.getFullName());
		user.setDateOfBirth(Date.valueOf(dto.getDateOfBirth()));
		user.setEmail(dto.getEmail());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setReward(dto.getReward());
		user.setPoint(dto.getPoint());
		user.setIsActived( dto.getIsActived().toString());
				
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setId(3L);
		roles.add(role);
		user.setRoles(roles);
		
		return user;
	}
}
