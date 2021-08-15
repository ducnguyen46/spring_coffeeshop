package com.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.constant.Constant;
import com.coffee.dto.ResponseDto;
import com.coffee.dto.UserDto;
import com.coffee.dto.UserLoginDto;
import com.coffee.dto.UserRegisterDto;
import com.coffee.dto.UserUpdatePasswordDto;
import com.coffee.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//login
	
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody UserLoginDto userLoginDto){
    	ResponseDto resultDto = userService.authenticateUser(userLoginDto);
    	
    	return new ResponseEntity<ResponseDto>(resultDto, HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserRegisterDto userRegister){
    	String result = userService.register(userRegister);
    	ResponseDto responseDto;
    	
    	switch (result) {
		case Constant.DUPLICATE_USERNAME:
			responseDto = new ResponseDto("ERROR", "Duplicate user");
			break;
			
		case Constant.USED_EMAIL:
			responseDto = new ResponseDto("ERROR", "Used email");
			break;
			
		case Constant.OTHER_ERROR:
			responseDto = new ResponseDto("ERROR", "Other error");
			break;
			
		default:
			responseDto = new ResponseDto("OK", "Successful registration");
			break;
		}
    	
    	return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    
    @PutMapping("/user/changePassword")
    public ResponseEntity<ResponseDto> changePassword(UserUpdatePasswordDto userUpdatePasswordDto){
    	String result = userService.updatePassword(userUpdatePasswordDto);
    	ResponseDto responseDto;
    	switch (result) {
		case Constant.WRONG_USERNAME_PASSWORD:
			responseDto = new ResponseDto("ERROR", "Wrong username or password");
			break;
			
		case Constant.OTHER_ERROR:
			responseDto = new ResponseDto("ERROR", "Something wrong :(");
			break;
			
		default:
			responseDto = new ResponseDto("OK", "Password is changed");
			break;
		}
    	return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    
    @GetMapping("/user/info")
    public ResponseEntity<UserDto> getOwnUserInfo(){
    	UserDto userDto = userService.getUserInfo();
    	return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
}
