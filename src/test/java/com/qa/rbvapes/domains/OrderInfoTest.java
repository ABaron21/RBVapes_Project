package com.qa.rbvapes.domains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderInfoTest {

	public OrderInfo info;
	private LocalDate date = LocalDate.now();
	private LocalDate dateD = date.plus(3, ChronoUnit.DAYS);

	@Test
	void gettersAndSettersTest() {
		info = new OrderInfo(1L, 1L, 1L, date, dateD);

		assertNotNull(info.getId());
		assertNotNull(info.getCustomerID());
		assertNotNull(info.getOrderID());
		assertNotNull(info.getDatePlaced());
		assertNotNull(info.getDeliveryDate());

		info.setId(null);
		assertNull(info.getId());
		info.setCustomerID(null);
		assertNull(info.getCustomerID());
		info.setOrderID(null);
		assertNull(info.getOrderID());
		info.setDatePlaced(null);
		assertNull(info.getDatePlaced());
		info.setDeliveryDate(null);
		assertNull(info.getDeliveryDate());
	}

	@Test
	void emptyConTest() {
		info = new OrderInfo();

		assertNull(info.getId());
		assertNull(info.getCustomerID());
		assertNull(info.getOrderID());
		assertNull(info.getDatePlaced());
		assertNull(info.getDeliveryDate());
	}

	@Test
	void conWithoutIdTest() {
		info = new OrderInfo(1L, 1L, date, dateD);

		assertNull(info.getId());
		assertNotNull(info.getCustomerID());
		assertNotNull(info.getOrderID());
		assertNotNull(info.getDatePlaced());
		assertNotNull(info.getDeliveryDate());
	}

	@Test
	void toStringTest() {
		info = new OrderInfo(1L, 1L, 1L, date, dateD);
		String toString = "OrderInfo [Id=1, customerID=1, orderID=1, datePlaced=" + date + ", deliveryDate=" + dateD
				+ "]";
		assertEquals(toString, info.toString());
	}

	@Test
	public void simpleEqualsContract() {
		EqualsVerifier.simple().forClass(OrderInfo.class).verify();
	}
}
