package com.qa.rbvapes.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Long customerID;
	private Long orderID;
	private String datePlaced;
	private String deliveryDate;

	public OrderInfo() {
		super();
	}

	public OrderInfo(Long id, Long customerID, Long orderID, String datePlaced, String deliveryDate) {
		super();
		Id = id;
		this.customerID = customerID;
		this.orderID = orderID;
		this.datePlaced = datePlaced;
		this.deliveryDate = deliveryDate;
	}

	public OrderInfo(Long customerID, Long orderID, String datePlaced, String deliveryDate) {
		super();
		this.customerID = customerID;
		this.orderID = orderID;
		this.datePlaced = datePlaced;
		this.deliveryDate = deliveryDate;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "OrderInfo [Id=" + Id + ", customerID=" + customerID + ", orderID=" + orderID + ", datePlaced="
				+ datePlaced + ", deliveryDate=" + deliveryDate + "]";
	}

}
