package com.coffee.dto;

public class UserRegisterDto {
	
	private String fullName;
	private String dateOfBirth;
	private String email;
	private String username;
	private String password;
	private String reward;
	private Long point;
	private Boolean isActived;

	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
