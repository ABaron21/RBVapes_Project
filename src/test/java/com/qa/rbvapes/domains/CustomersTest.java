package com.qa.rbvapes.domains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class CustomersTest {

	public Customers customer;

	@Test
	void gettersAndSettersTest() {
		customer = new Customers(1L, "Name", "Address", "Number");

		assertNotNull(customer.getId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getPhoneNumber());

		customer.setId(null);
		assertNull(customer.getId());
		customer.setName(null);
		assertNull(customer.getName());
		customer.setAddress(null);
		assertNull(customer.getAddress());
		customer.setPhoneNumber(null);
		assertNull(customer.getPhoneNumber());
	}

	@Test
	void emptyConstructorTest() {
		customer = new Customers();
		assertNull(customer.getId());
		assertNull(customer.getName());
		assertNull(customer.getAddress());
		assertNull(customer.getPhoneNumber());
	}

	@Test
	void constructorWithoutId() {
		customer = new Customers("Name", "Address", "Number");
		assertNull(customer.getId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getPhoneNumber());
	}

	@Test
	void toStringTest() {
		customer = new Customers(1L, "Name", "Address", "Number");
		String toString = "Customers [Id=1, Name=Name, Address=Address, phoneNumber=Number]";
		assertEquals(toString, customer.toString());
	}
}
