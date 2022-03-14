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

import com.qa.rbvapes.domains.Flavours;
import com.qa.rbvapes.repos.FlavourRepo;

@SpringBootTest
public class FlavourServiceTest {

	private Flavours newFlavour;
	private Flavours savedFlavour;

	@MockBean
	private FlavourRepo repo;

	@Autowired
	private FlavourService service;

	@BeforeEach
	void setUp() {
		newFlavour = new Flavours("CottonCandy", "AromaKing", 15);
		savedFlavour = new Flavours(1L, "CottonCandy", "AromaKing", 15);
	}

	@Test
	public void testCreatingNew() {
		Mockito.when(repo.save(newFlavour)).thenReturn(savedFlavour);

		assertThat(this.service.createNew(newFlavour)).isEqualTo(savedFlavour);

		Mockito.verify(this.repo, Mockito.times(1)).save(newFlavour);
	}

	@Test
	public void testUpdate() {
		Long id = 1L;
		Flavours returned = savedFlavour;
		int updateQtn = 18;
		Flavours updated = new Flavours(id, savedFlavour.getFlavourName(), savedFlavour.getBrandName(), updateQtn);

		Mockito.when(this.repo.save(savedFlavour)).thenReturn(savedFlavour);
		Mockito.when(this.repo.getById(id)).thenReturn(returned);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		assertThat(this.service.updateInfo(id, updateQtn)).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).save(savedFlavour);
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
		List<Flavours> list = new ArrayList<>();
		list.add(newFlavour);

		Mockito.when(this.repo.findAll()).thenReturn(list);

		assertThat(this.service.readAll()).isEqualTo(list);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadByBrand() {
		String name = "AromaKing";
		List<Flavours> expected = new ArrayList<>();
		expected.add(newFlavour);

		Mockito.when(this.repo.findAllByBrandName(name)).thenReturn(expected);

		List<Flavours> result = this.service.readFlavours(name);

		assertThat(result).isNotNull();

		Mockito.verify(this.repo, Mockito.times(1)).findAllByBrandName(name);
	}
}
