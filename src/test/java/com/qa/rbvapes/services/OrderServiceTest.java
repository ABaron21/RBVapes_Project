package com.qa.rbvapes.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.rbvapes.domains.Brands;
import com.qa.rbvapes.domains.Flavours;
import com.qa.rbvapes.domains.Orders;
import com.qa.rbvapes.repos.BrandRepo;
import com.qa.rbvapes.repos.FlavourRepo;
import com.qa.rbvapes.repos.OrderRepo;

@SpringBootTest
public class OrderServiceTest {

	private Orders newOrder;
	private Orders savedOrder;
	private Brands brand;
	private Flavours flavour;
	private Brands newBrand;
	private Flavours newFlavour;

	@MockBean
	private OrderRepo repo;
	@MockBean
	private BrandRepo Brepo;
	@MockBean
	private FlavourRepo Frepo;

	@Autowired
	private OrderService service;

	@BeforeEach
	void setUp() {
		newOrder = new Orders(1, "Elux", 1L, "BlueIce", 2, 20);
		savedOrder = new Orders(1L, 1, "Elux", 1L, "BlueIce", 2, 20);
		brand = new Brands("Elux", 3000, 10.00);
		flavour = new Flavours("BlueIce", "Elux", 15);
		newBrand = new Brands("Aroma", 7000, 15.00);
		newFlavour = new Flavours("CottonCandy", "Aroma", 12);
	}

	@Test
	public void testCreatingNew() {
		int bID = 1;
		Long fID = 1L;
		Brands returnB = brand;
		Flavours returnF = flavour;
		Orders expected = new Orders(1L, brand.getId(), "Elux", flavour.getId(), "BlueIce", 2, 20);

		Mockito.when(this.Brepo.save(brand)).thenReturn(brand);
		Mockito.when(this.Frepo.save(flavour)).thenReturn(flavour);
		Mockito.when(this.Brepo.getById(bID)).thenReturn(returnB);
		Mockito.when(this.Frepo.getById(fID)).thenReturn(returnF);
		Mockito.when(repo.save(newOrder)).thenReturn(expected);

		assertThat(this.service.createNew(newOrder)).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).save(newOrder);
	}

	@Test
	public void testUpdate() {
		Long id = 1L;
		int bID = 2;
		Long fID = 2L;
		Brands returnB = newBrand;
		Flavours returnF = newFlavour;
		Orders returned = savedOrder;
		Orders first = new Orders(2, "Aroma", 2L, "CottonCandy", 1, 15);
		Orders updated = new Orders(id, first.getBrandID(), first.getBrandName(), first.getFlavourID(),
				first.getFlavourName(), first.getItemQuantity(), first.getOrderPrice());

		Mockito.when(this.repo.save(savedOrder)).thenReturn(savedOrder);
		Mockito.when(this.Brepo.save(newBrand)).thenReturn(newBrand);
		Mockito.when(this.Frepo.save(newFlavour)).thenReturn(newFlavour);
		Mockito.when(this.repo.getById(id)).thenReturn(returned);
		Mockito.when(this.Brepo.getById(bID)).thenReturn(returnB);
		Mockito.when(this.Frepo.getById(fID)).thenReturn(returnF);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		Orders result = this.service.update(id, first);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).save(savedOrder);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
		Mockito.verify(this.repo, Mockito.times(1)).getById(id);
	}

	@Test
	public void testReadAll() {
		List<Orders> list = new ArrayList<>();
		list.add(savedOrder);

		Mockito.when(this.repo.findAll()).thenReturn(list);
		assertThat(this.service.readAll()).isEqualTo(list);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadId() {
		Long id = 1L;
		Orders first = new Orders(id, 1, "Elux", 1L, "BlueIce", 2, 20);
		Optional<Orders> optOrder = Optional.of(first);
		Orders expected = new Orders(first.getId(), first.getBrandID(), first.getBrandName(), first.getFlavourID(),
				first.getFlavourName(), first.getItemQuantity(), first.getOrderPrice());

		Mockito.when(this.repo.findById(id)).thenReturn(optOrder);

		Orders result = this.service.readById(id);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	public void testDelete() {
		Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.delete(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
	}

}
