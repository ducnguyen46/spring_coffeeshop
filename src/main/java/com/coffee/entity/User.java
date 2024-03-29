package com.coffee.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coffee.dto.UserRegisterDto;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	private Date dateOfBirth;
	private String email;
	private String username;
	private String password;
	
	@ManyToMany
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	private String reward;
	private Long point;
	
	@OneToMany(mappedBy = "user")
	private List<DeliveryInfo> deliveryInfos;
	
	private String isActived;
	
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	

	public User(UserRegisterDto userRegister) {
		this.fullName = userRegister.getFullName();
		this.dateOfBirth = Date.valueOf(userRegister.getDateOfBirth());
		this.email = userRegister.getEmail();
		this.username = userRegister.getUsername();
		this.password = userRegister.getPassword();
		this.reward = userRegister.getReward();
		this.point = userRegister.getPoint();
		this.isActived = userRegister.getIsActived().toString();

		List<Role> roles = new ArrayList<>();
		Role role = new Role();
		role.setId(3L);
		roles.add(role);
		
		this.roles = roles;
	}
	
	public User() {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public List<DeliveryInfo> getDeliveryInfos() {
		return deliveryInfos;
	}

	public void setDeliveryInfos(List<DeliveryInfo> deliveryInfos) {
		this.deliveryInfos = deliveryInfos;
	}

	public String getIsActived() {
		return isActived;
	}

	public void setIsActived(String isActived) {
		this.isActived = isActived;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
