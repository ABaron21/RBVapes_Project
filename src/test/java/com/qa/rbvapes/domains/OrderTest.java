package com.qa.rbvapes.domains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class OrderTest {

	public Orders order;

	@Test
	void gettersAndSettersTest() {
		order = new Orders(1L, 1, 2L, 29.98, 2);

		assertNotNull(order.getId());
		assertNotNull(order.getBrandID());
		assertNotNull(order.getFlavourID());
		assertNotNull(order.getOrderPrice());
		assertNotNull(order.getItemQuantity());

		order.setId(null);
		assertNull(order.getId());
		order.setBrandID(0);
		assertEquals(0, order.getBrandID());
		order.setFlavourID(null);
		assertNull(order.getFlavourID());
		order.setOrderPrice(0);
		assertNotNull(order.getOrderPrice());
		order.setItemQuantity(0);
		assertEquals(0, order.getItemQuantity());
		order.setBrandName(null);
		assertNull(order.getBrandName());
		order.setFlavourName(null);
		assertNull(order.getFlavourName());
	}

	@Test
	void emptyConstructorTest() {
		order = new Orders();

		assertNull(order.getId());
		assertEquals(0, order.getBrandID());
		assertNull(order.getFlavourID());
		assertNotNull(order.getOrderPrice());
		assertEquals(0, order.getItemQuantity());
		assertNull(order.getBrandName());
		assertNull(order.getFlavourName());
	}

	@Test
	void conWithoutIdTestOne() {
		order = new Orders(1, 2L, 29.98, 2);

		assertNull(order.getId());
		assertNotNull(order.getBrandID());
		assertNotNull(order.getFlavourID());
		assertNotNull(order.getOrderPrice());
		assertNotNull(order.getItemQuantity());
	}

	@Test
	void nameConTest() {
		order = new Orders(1L, "Brand", "Flavour", 2, 29.98);

		assertNotNull(order.getId());
		assertNotNull(order.getBrandName());
		assertNotNull(order.getFlavourName());
		assertNotNull(order.getItemQuantity());
		assertNotNull(order.getOrderPrice());
	}

	@Test
	void conWithoutIdTwo() {
		order = new Orders("Brand", "Flavour", 2, 29.98);

		assertNull(order.getId());
		assertNotNull(order.getBrandName());
		assertNotNull(order.getFlavourName());
		assertNotNull(order.getItemQuantity());
		assertNotNull(order.getOrderPrice());
	}

	@Test
	void toStringTest() {
		order = new Orders(1L, "Brand", "Flavour", 2, 29.98);
		String toString = "Orders [Id=1, brandName=Brand, flavourName=Flavour, itemQuantity=2, orderPrice=29.98]";
		assertEquals(toString, order.toString());
	}

}
