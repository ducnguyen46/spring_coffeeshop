package com.coffee.model;

import java.util.ArrayList;
import java.util.List;

import com.coffee.entity.Item;
import com.coffee.entity.Order;

public class OrderModel {
	
	private Long id;
	private List<ItemModel> items;
	private String orderDate;
	private ShipmentModel shipment;
	private VoucherModel voucher;
	private UserModel user;
	
	public OrderModel(Order order) {
		this.id = order.getId();
		this.orderDate = order.getOrderDate().toString();
		this.shipment = new ShipmentModel(order.getShipment());
		this.voucher = new VoucherModel(order.getVoucher());
		this.user = new UserModel(order.getUser());
		
		List<ItemModel> listItems = new ArrayList<>();
		for(Item item : order.getItems()) {
			listItems.add(new ItemModel(item));
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ItemModel> getItems() {
		return items;
	}
	public void setItems(List<ItemModel> items) {
		this.items = items;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public ShipmentModel getShipment() {
		return shipment;
	}
	public void setShipment(ShipmentModel shipment) {
		this.shipment = shipment;
	}
	public VoucherModel getVoucher() {
		return voucher;
	}
	public void setVoucher(VoucherModel voucher) {
		this.voucher = voucher;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}

}
