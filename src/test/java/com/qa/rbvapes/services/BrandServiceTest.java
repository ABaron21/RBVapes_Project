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

import com.qa.rbvapes.domains.Brands;
import com.qa.rbvapes.repos.BrandRepo;

@SpringBootTest
public class BrandServiceTest {

	private Brands newBrand;
	private Brands savedBrand;

	@MockBean
	private BrandRepo repo;

	@Autowired
	private BrandService service;

	@BeforeEach
	void setUp() {
		newBrand = new Brands("Aroma King", 7000, 15.00);
		savedBrand = new Brands(1, "Aroma King", 7000, 15.00);
	}

	@Test
	public void testCreatingNew() {
		Mockito.when(repo.save(newBrand)).thenReturn(savedBrand);

		assertThat(this.service.createNew(newBrand)).isEqualTo(savedBrand);

		Mockito.verify(this.repo, Mockito.times(1)).save(newBrand);
	}

	@Test
	public void testUpdate() {
		int id = 1;
		Brands returned = savedBrand;
		Brands update = new Brands("Elux", 3000, 10.00);
		Brands updated = new Brands(id, update.getBrandName(), update.getPuffCount(), update.getPrice());

		Mockito.when(this.repo.save(savedBrand)).thenReturn(savedBrand);
		Mockito.when(this.repo.getById(id)).thenReturn(returned);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		assertThat(this.service.update(id, update)).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).save(savedBrand);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
		Mockito.verify(this.repo, Mockito.times(1)).getById(id);
	}

	@Test
	public void testDelete() {

		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.delete(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
	}

	@Test
	public void testReadAll() {
		List<Brands> list = new ArrayList<>();
		list.add(newBrand);

		Mockito.when(this.repo.findAll()).thenReturn(list);

		assertThat(this.service.readAll()).isEqualTo(list);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadByName() {
		String name = "Elux";
		Brands first = new Brands(1, "Elux", 3000, 10.00);
		Brands expected = new Brands(first.getId(), first.getBrandName(), first.getPuffCount(), first.getPrice());

		Mockito.when(this.repo.findByBrandName(name)).thenReturn(expected);

		Brands result = this.service.readBrandName(name);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findByBrandName(name);
	}
}
