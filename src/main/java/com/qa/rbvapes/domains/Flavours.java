package com.qa.rbvapes.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flavours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String flavourName;
	private int brandID;
	private int Quantity;

	public Flavours() {
		super();
	}

	public Flavours(Long id, String flavourName, int brandID, int quantity) {
		super();
		Id = id;
		this.flavourName = flavourName;
		this.brandID = brandID;
		this.Quantity = quantity;
	}

	public Flavours(String flavourName, int brandID, int quantity) {
		super();
		this.flavourName = flavourName;
		this.brandID = brandID;
		this.Quantity = quantity;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFlavourName() {
		return flavourName;
	}

	public void setFlavourName(String flavourName) {
		this.flavourName = flavourName;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "Flavours [Id=" + Id + ", flavourName=" + flavourName + ", brandID=" + brandID + ", Quantity=" + Quantity
				+ "]";
	}

}
