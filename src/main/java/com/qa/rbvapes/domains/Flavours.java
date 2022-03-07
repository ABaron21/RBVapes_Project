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
	private String brandName;
	private int Quantity;

	public Flavours() {
		super();
	}

	public Flavours(Long id, String flavourName, String brandName, int quantity) {
		super();
		this.Id = id;
		this.flavourName = flavourName;
		this.brandName = brandName;
		Quantity = quantity;
	}

	public Flavours(String flavourName, String brandName, int quantity) {
		super();
		this.flavourName = flavourName;
		this.brandName = brandName;
		Quantity = quantity;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "Flavours [Id=" + Id + ", flavourName=" + flavourName + ", brandName=" + brandName + ", Quantity="
				+ Quantity + "]";
	}

}
