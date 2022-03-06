package com.qa.rbvapes.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String brandName;
	private int puffCount;
	private double Price;

	public Brands() {
		super();
	}

	public Brands(Long id, String brandName, int puffCount, double price) {
		super();
		Id = id;
		this.brandName = brandName;
		this.puffCount = puffCount;
		Price = price;
	}

	public Brands(String brandName, int puffCount, double price) {
		super();
		this.brandName = brandName;
		this.puffCount = puffCount;
		Price = price;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
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

}
