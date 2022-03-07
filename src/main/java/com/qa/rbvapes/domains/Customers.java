package com.qa.rbvapes.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String Name;
	private String Address;
	private String phoneNumber;

	public Customers() {
		super();
	}

	public Customers(Long id, String name, String address, String phoneNumber) {
		super();
		this.Id = id;
		this.Name = name;
		this.Address = address;
		this.phoneNumber = phoneNumber;
	}

	public Customers(String name, String address, String phoneNumber) {
		super();
		this.Name = name;
		this.Address = address;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customers [Id=" + Id + ", Name=" + Name + ", Address=" + Address + ", phoneNumber=" + phoneNumber + "]";
	}

}
