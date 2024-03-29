package com.coffee.model;

import com.coffee.entity.Shipment;

public class ShipmentModel {
	
	public ShipmentModel(Shipment shipment) {
		this.id = shipment.getId();
		this.deliveryInfo = new DeliveryInfoModel(shipment.getDeliveryInfo());
		this.isCompleted = shipment.getIsCompleted().equalsIgnoreCase("true");
		this.shipperId = shipment.getShipperId();
		this.shipperName = shipment.getShipperName();
		this.shipperPhone = shipment.getShipperPhone();
	}
	
	private Long id;
	private DeliveryInfoModel deliveryInfo;
	private Boolean isCompleted;
	private String shipperId;
	private String shipperName;
	private String shipperPhone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DeliveryInfoModel getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(DeliveryInfoModel deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getShipperId() {
		return shipperId;
	}
	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getShipperPhone() {
		return shipperPhone;
	}
	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}
	
	
}
