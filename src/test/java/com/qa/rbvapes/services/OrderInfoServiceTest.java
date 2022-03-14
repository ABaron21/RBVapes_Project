package com.qa.rbvapes.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.rbvapes.domains.Customers;
import com.qa.rbvapes.domains.OrderInfo;
import com.qa.rbvapes.repos.OrderInfoRepo;

@SpringBootTest
public class OrderInfoServiceTest {

	private OrderInfo newInfo;
	private OrderInfo savedInfo;
	private LocalDate date = LocalDate.now();
	private LocalDate dateD = date.plus(3, ChronoUnit.DAYS);

	@MockBean
	private OrderInfoRepo repo;

	@Autowired
	private OrderInfoService service;

	@BeforeEach
	void setUp() {
		newInfo = new OrderInfo(1L, 1L, date, dateD);
		savedInfo = new OrderInfo(1L, 1L, 1L, date, dateD);
	}

	@Test
	public void testCreatingNew() {
		Mockito.when(this.repo.save(newInfo)).thenReturn(savedInfo);
		assertThat(this.service.create(newInfo)).isEqualTo(savedInfo);

		Mockito.verify(this.repo, Mockito.times(1)).save(newInfo);
	}

	@Test
	public void testCreateBasedonOrder() {
		Long cID = 1L;
		Long oID = 1L;
		Customers customer = new Customers(cID, "Alex", "Address", "Number");
		OrderInfo expected = new OrderInfo(1L, cID, oID, date, dateD);

		Mockito.when(this.repo.save(newInfo)).thenReturn(expected);
		assertThat(this.service.createInfo(cID, oID)).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).save(newInfo);
	}

	@Test
	public void testUpdate() {
		Long id = 1L;
		OrderInfo returned = savedInfo;
		OrderInfo update = new OrderInfo(1L, 1L, dateD, dateD);
		OrderInfo updated = new OrderInfo(id, update.getCustomerID(), update.getOrderID(), update.getDatePlaced(),
				update.getDeliveryDate());

		Mockito.when(this.repo.save(savedInfo)).thenReturn(savedInfo);
		Mockito.when(this.repo.getById(id)).thenReturn(returned);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		OrderInfo result = this.service.update(id, update);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).save(savedInfo);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
		Mockito.verify(this.repo, Mockito.times(1)).getById(id);
	}

	@Test
	public void testDelete() {

		Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.delete(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
	}

	@Test
	public void testReadAll() {
		List<OrderInfo> list = new ArrayList<>();
		list.add(savedInfo);

		Mockito.when(this.repo.findAll()).thenReturn(list);
		assertThat(this.service.readAll()).isEqualTo(list);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadByDeliveryDate() {
		List<OrderInfo> expected = new ArrayList<>();
		expected.add(newInfo);

		Mockito.when(this.repo.findAllByDeliveryDate(dateD)).thenReturn(expected);

		List<OrderInfo> result = this.service.readDelivery(dateD);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findAllByDeliveryDate(dateD);
	}

	@Test
	public void testReadByDatePlaced() {
		List<OrderInfo> expected = new ArrayList<>();
		expected.add(newInfo);

		Mockito.when(this.repo.findAllByDatePlaced(date)).thenReturn(expected);

		List<OrderInfo> result = this.service.readDatePlaced(date);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findAllByDatePlaced(date);
	}
}
