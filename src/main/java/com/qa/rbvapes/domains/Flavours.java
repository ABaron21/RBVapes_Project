package com.qa.rbvapes.domains;

import java.util.Objects;

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

	public Flavours(int quantity) {
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

	@Override
	public int hashCode() {
		return Objects.hash(Quantity, brandName, flavourName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flavours other = (Flavours) obj;
		return Quantity == other.Quantity && Objects.equals(brandName, other.brandName)
				&& Objects.equals(flavourName, other.flavourName);
	}

}
