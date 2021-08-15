package com.coffee.dto;

import com.coffee.model.UserModel;

public class UserDto {
	private Long id;
	private String fullName;
	private String dateOfBirth;
	private String email;
	private String username;
	private String reward;
	private Long point;
	private Boolean isActived;
	
	
	public UserDto(UserModel user) {
		this.id = user.getId();
		this.fullName = user.getFullName();
		this.dateOfBirth = user.getDateOfBirth().toString();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.reward = user.getReward();
		this.point = user.getPoint();
		this.isActived = user.getIsActived();
	}

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getReward() {
		return reward;
	}


	public void setReward(String reward) {
		this.reward = reward;
	}


	public Long getPoint() {
		return point;
	}


	public void setPoint(Long point) {
		this.point = point;
	}


	public Boolean getIsActived() {
		return isActived;
	}


	public void setIsActived(Boolean isActived) {
		this.isActived = isActived;
	}
}
