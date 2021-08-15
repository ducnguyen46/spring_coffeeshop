package com.coffee.service;

import java.util.List;

import com.coffee.constant.Constant;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.coffee.dto.CustomUserDetail;
import com.coffee.dto.ResponseDto;
import com.coffee.dto.UserDto;
import com.coffee.dto.UserLoginDto;
import com.coffee.dto.UserRegisterDto;
import com.coffee.dto.UserUpdatePasswordDto;
import com.coffee.entity.User;
import com.coffee.model.UserModel;
import com.coffee.repository.UserRepository;
import com.coffee.security.JwtTokenProvider;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public ResponseDto authenticateUser(@RequestBody UserLoginDto userLogin) {

		ResponseDto result;
		// Xác thực từ username và password.
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));

		// Nếu không xảy ra exception tức là thông tin hợp lệ
		// Set thông tin authentication vào Security Context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Trả về jwt cho người dùng.
		String jwt = tokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
		result = new ResponseDto("OK", jwt);
		return result;
	}

	@Transactional
	public String updatePassword(UserUpdatePasswordDto userUpdatePassword) {
		List<User> users = userRepository.getUserByUsernamePassword(userUpdatePassword.getUsername(),
				passwordEncoder.encode(userUpdatePassword.getOldPassword()));
		if (users.isEmpty()) {
			return Constant.WRONG_USERNAME_PASSWORD;
		} else {
			int status = userRepository.updateUserPassword(userUpdatePassword.getUsername(),
					passwordEncoder.encode(userUpdatePassword.getNewPassword()));
			if (status != 0) {
				return Constant.OK;
			} else {
				return Constant.OTHER_ERROR;
			}
		}
	}

	@Transactional
	public String register(UserRegisterDto userRegister) {
		List<User> userCheckUsername = userRepository.getUserByUsername(userRegister.getUsername());
		if (!userCheckUsername.isEmpty()) {
			return Constant.DUPLICATE_USERNAME;
		} else {
			List<User> userCheckEmail = userRepository.getUserByEmail(userRegister.getEmail());
			if (!userCheckEmail.isEmpty()) {
				return Constant.USED_EMAIL;
			}
			User user = new User(userRegister);
			
			user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
			userRepository.save(user);
			
			return Constant.OK;
		}
	}
	
	public UserDto getUserInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    User user = userRepository.getUserByUsername(currentUserName).get(0);
		    UserDto userDto = new UserDto(new UserModel(user));
		    return userDto;
		}
		return new UserDto();
	}
}
