package com.qa.rbvapes.domains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class FlavoursTest {

	public Flavours flavour;

	@Test
	void gettersAndSettersTest() {
		flavour = new Flavours(1L, "Name", "Brand", 15);

		assertNotNull(flavour.getId());
		assertNotNull(flavour.getFlavourName());
		assertNotNull(flavour.getBrandName());
		assertNotNull(flavour.getQuantity());

		flavour.setId(null);
		assertNull(flavour.getId());
		flavour.setFlavourName(null);
		assertNull(flavour.getFlavourName());
		flavour.setBrandName(null);
		assertNull(flavour.getBrandName());
		flavour.setQuantity(0);
		assertEquals(0, flavour.getQuantity());
	}

	@Test
	void emptyConstructorTest() {
		flavour = new Flavours();
		assertNull(flavour.getId());
		assertNull(flavour.getFlavourName());
		assertNull(flavour.getBrandName());
		assertEquals(0, flavour.getQuantity());
	}

	@Test
	void constructorWithoutIdTest() {
		flavour = new Flavours("Name", "Brand", 15);
		assertNull(flavour.getId());
		assertNotNull(flavour.getFlavourName());
		assertNotNull(flavour.getBrandName());
		assertNotNull(flavour.getQuantity());
	}

	@Test
	void toStringTest() {
		flavour = new Flavours(1L, "Name", "Brand", 15);
		String toString = "Flavours [Id=1, flavourName=Name, brandName=Brand, Quantity=15]";
		assertEquals(toString, flavour.toString());
	}
}
