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

	private int brandID;
	private String brandName;
	private Long flavourID;
	private String flavourName;
	private int itemQuantity;
	private double orderPrice;

	public Orders() {
		super();
	}

	public Orders(Long id, int brandID, Long flavourID, double orderPrice, int itemQuantity) {
		super();
		Id = id;
		this.brandID = brandID;
		this.flavourID = flavourID;
		this.itemQuantity = itemQuantity;
		this.orderPrice = orderPrice;
	}

	public Orders(int brandID, Long flavourID, double orderPrice, int itemQuantity) {
		super();
		this.brandID = brandID;
		this.flavourID = flavourID;
		this.itemQuantity = itemQuantity;
		this.orderPrice = orderPrice;
	}

	public Orders(Long id, String brandName, String flavourName, int itemQuantity, double orderPrice) {
		super();
		Id = id;
		this.brandName = brandName;
		this.flavourName = flavourName;
		this.itemQuantity = itemQuantity;
		this.orderPrice = orderPrice;
	}

	public Orders(String brandName, String flavourName, int itemQuantity, double orderPrice) {
		super();
		this.brandName = brandName;
		this.flavourName = flavourName;
		this.itemQuantity = itemQuantity;
		this.orderPrice = orderPrice;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getFlavourName() {
		return flavourName;
	}

	public void setFlavourName(String flavourName) {
		this.flavourName = flavourName;
	}

	@Override
	public String toString() {
		return "Orders [Id=" + Id + ", brandName=" + brandName + ", flavourName=" + flavourName + ", itemQuantity="
				+ itemQuantity + ", orderPrice=" + orderPrice + "]";
	}

}
