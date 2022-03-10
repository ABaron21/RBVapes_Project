package com.qa.rbvapes.domains;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String brandName;
	private int puffCount;
	private double Price;

	public Brands() {
		super();
	}

	public Brands(int id, String brandName, int puffCount, double price) {
		super();
		Id = id;
		this.brandName = brandName;
		this.puffCount = puffCount;
		this.Price = price;
	}

	public Brands(String brandName, int puffCount, double price) {
		super();
		this.brandName = brandName;
		this.puffCount = puffCount;
		this.Price = price;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getPuffCount() {
		return puffCount;
	}

	public void setPuffCount(int puffCount) {
		this.puffCount = puffCount;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Brands [Id=" + Id + ", brandName=" + brandName + ", puffCount=" + puffCount + ", Price=" + Price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Price, brandName, puffCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brands other = (Brands) obj;
		return Double.doubleToLongBits(Price) == Double.doubleToLongBits(other.Price)
				&& Objects.equals(brandName, other.brandName) && puffCount == other.puffCount;
	}

}
