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
	private String datePlaced;
	private String deliveryDate;

	public Orders() {
		super();
	}

	public Orders(Long id, Long customerID, int brandID, Long flavourID, double orderPrice, String datePlaced,
			String deliveryDate) {
		super();
		Id = id;
		this.customerID = customerID;
		this.brandID = brandID;
		this.flavourID = flavourID;
		this.orderPrice = orderPrice;
		this.datePlaced = datePlaced;
		this.deliveryDate = deliveryDate;
	}

	public Orders(Long customerID, int brandID, Long flavourID, double orderPrice, String datePlaced,
			String deliveryDate) {
		super();
		this.customerID = customerID;
		this.brandID = brandID;
		this.flavourID = flavourID;
		this.orderPrice = orderPrice;
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
		return "Orders [Id=" + Id + ", customerID=" + customerID + ", brandID=" + brandID + ", flavourID=" + flavourID
				+ ", orderPrice=" + orderPrice + ", datePlaced=" + datePlaced + ", deliveryDate=" + deliveryDate + "]";
	}

}
