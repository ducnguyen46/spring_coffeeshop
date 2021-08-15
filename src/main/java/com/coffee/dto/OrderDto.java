package com.coffee.dto;

import java.util.List;

import com.coffee.model.ItemModel;

public class OrderDto {
	private List<ItemModel> items;
	private Long voucherId;
	private Long deliveryId;
	
	
	public List<ItemModel> getItems() {
		return items;
	}
	public void setItems(List<ItemModel> items) {
		this.items = items;
	}
	public Long getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	
	
}
