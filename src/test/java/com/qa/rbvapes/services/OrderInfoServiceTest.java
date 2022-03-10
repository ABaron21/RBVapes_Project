package com.qa.rbvapes.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.rbvapes.domains.OrderInfo;
import com.qa.rbvapes.repos.OrderInfoRepo;

@SpringBootTest
public class OrderInfoServiceTest {

	private OrderInfo newInfo;
	private OrderInfo savedInfo;

	@MockBean
	private OrderInfoRepo repo;

	@Autowired
	private OrderInfoService service;

	@BeforeEach
	void setUp() {
		newInfo = new OrderInfo(1L, 1L, "2022-03-09", "2022-03-12");
		savedInfo = new OrderInfo(1L, 1L, 1L, "2022-03-09", "2022-03-12");
	}

	@Test
	public void testCreatingNew() {
		Mockito.when(this.repo.save(newInfo)).thenReturn(savedInfo);
		assertThat(this.service.create(newInfo)).isEqualTo(savedInfo);

		Mockito.verify(this.repo, Mockito.times(1)).save(newInfo);
	}

	@Test
	public void testUpdate() {
		Long id = 1L;
		OrderInfo returned = savedInfo;
		OrderInfo update = new OrderInfo(1L, 1L, "2022-03-10", "2022-03-13");
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
		String date = "2022-03-12";
		List<OrderInfo> expected = new ArrayList<>();
		expected.add(newInfo);

		Mockito.when(this.repo.findAllByDeliveryDate(date)).thenReturn(expected);

		List<OrderInfo> result = this.service.readDelivery(date);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findAllByDeliveryDate(date);
	}

	@Test
	public void testReadByDatePlaced() {
		String date = "2022-03-09";
		List<OrderInfo> expected = new ArrayList<>();
		expected.add(newInfo);

		Mockito.when(this.repo.findAllByDatePlaced(date)).thenReturn(expected);

		List<OrderInfo> result = this.service.readDatePlaced(date);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findAllByDatePlaced(date);
	}
}
