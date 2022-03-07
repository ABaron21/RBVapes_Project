package com.qa.rbvapes.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Long customerID;
	private int brandID;
	private Long flavourID;
	private double orderPrice;
	private int itemQuantity;

	public Orders() {
		super();
	}

	public Orders(Long id, Long customerID, int brandID, Long flavourID, double orderPrice, int itemQuantity) {
		super();
		Id = id;
		this.customerID = customerID;
		this.brandID = brandID;
		this.flavourID = flavourID;
		this.orderPrice = orderPrice;
		this.itemQuantity = itemQuantity;
	}

	public Orders(Long customerID, int brandID, Long flavourID, double orderPrice, int itemQuantity) {
		super();
		this.customerID = customerID;
		this.brandID = brandID;
		this.flavourID = flavourID;
		this.orderPrice = orderPrice;
		this.itemQuantity = itemQuantity;
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

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public Long getFlavourID() {
		return flavourID;
	}

	public void setFlavourID(Long flavourID) {
		this.flavourID = flavourID;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "Orders [Id=" + Id + ", customerID=" + customerID + ", brandID=" + brandID + ", flavourID=" + flavourID
				+ ", orderPrice=" + orderPrice + ", itemQuantity=" + itemQuantity + "]";
	}

}
