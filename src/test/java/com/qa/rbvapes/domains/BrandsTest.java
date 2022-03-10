package com.qa.rbvapes.domains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class BrandsTest {

	public Brands brand;

	@Test
	void gettersAndSettersTest() {
		brand = new Brands(1, "Name", 500, 14.99);

		assertNotNull(brand.getId());
		assertNotNull(brand.getBrandName());
		assertNotNull(brand.getPuffCount());
		assertNotNull(brand.getPrice());

		brand.setId(0);
		assertNotNull(brand.getId());
		brand.setBrandName(null);
		assertNull(brand.getBrandName());
		brand.setPuffCount(0);
		assertNotNull(brand.getPuffCount());
		brand.setPrice(0);
		assertNotNull(brand.getPrice());

	}

	@Test
	void emptyConstuctorTest() {
		brand = new Brands();
		assertNotNull(brand.getId());
		assertNull(brand.getBrandName());
		assertNotNull(brand.getPuffCount());
		assertNotNull(brand.getPrice());
	}

	@Test
	void constructorWithoutIdTest() {
		brand = new Brands("Name", 500, 14.99);
		assertNotNull(brand.getId());
		assertNotNull(brand.getBrandName());
		assertNotNull(brand.getPuffCount());
		assertNotNull(brand.getPrice());
	}

	@Test
	void toStringTest() {
		brand = new Brands(1, "Name", 500, 14.99);
		String toString = "Brands [Id=1, brandName=Name, puffCount=500, Price=14.99]";
		assertEquals(toString, brand.toString());
	}

	@Test
	public void simpleEqualsContract() {
		EqualsVerifier.simple().forClass(Brands.class).verify();
	}
}
