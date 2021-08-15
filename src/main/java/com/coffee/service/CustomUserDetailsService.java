package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coffee.dto.CustomUserDetail;
import com.coffee.entity.User;
import com.coffee.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		
		List<User> users = userRepository.getUserByUsername(username);
		User user;
		if(!users.isEmpty()) {
			user = users.get(0);
		} else {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetail(user);
		
	}

	public UserDetails loadUserById(Long userId) {
		User user = userRepository.getById(userId);
		if(user != null) {
			return new CustomUserDetail(user);
		}
		return new CustomUserDetail(user);
	}
	
	

}
