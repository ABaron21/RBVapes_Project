package com.qa.rbvapes.domains;

import java.time.LocalDate;
import java.util.Objects;

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
	private LocalDate datePlaced;
	private LocalDate deliveryDate;

	public OrderInfo() {
		super();
	}

	public OrderInfo(Long id, Long customerID, Long orderID, LocalDate datePlaced, LocalDate deliveryDate) {
		super();
		Id = id;
		this.customerID = customerID;
		this.orderID = orderID;
		this.datePlaced = datePlaced;
		this.deliveryDate = deliveryDate;
	}

	public OrderInfo(Long customerID, Long orderID, LocalDate datePlaced, LocalDate deliveryDate) {
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

	public LocalDate getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(LocalDate date) {
		this.datePlaced = date;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "OrderInfo [Id=" + Id + ", customerID=" + customerID + ", orderID=" + orderID + ", datePlaced="
				+ datePlaced + ", deliveryDate=" + deliveryDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, datePlaced, deliveryDate, orderID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInfo other = (OrderInfo) obj;
		return Objects.equals(customerID, other.customerID) && Objects.equals(datePlaced, other.datePlaced)
				&& Objects.equals(deliveryDate, other.deliveryDate) && Objects.equals(orderID, other.orderID);
	}

}
