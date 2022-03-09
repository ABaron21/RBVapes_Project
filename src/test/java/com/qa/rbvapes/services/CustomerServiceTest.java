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

import com.qa.rbvapes.domains.Customers;
import com.qa.rbvapes.repos.CustomerRepo;

@SpringBootTest
public class CustomerServiceTest {

	private Customers newCustomer;
	private Customers savedCustomer;

	@MockBean
	private CustomerRepo repo;

	@Autowired
	private CustomerService service;

	@BeforeEach
	void setUp() {
		newCustomer = new Customers("Alex", "Address", "Number");
		savedCustomer = new Customers(1L, "Alex", "Address", "Number");
	}

	@Test
	public void testCreatingNew() {
		Mockito.when(this.repo.save(newCustomer)).thenReturn(savedCustomer);
		assertThat(this.service.createNew(newCustomer)).isEqualTo(savedCustomer);

		Mockito.verify(this.repo, Mockito.times(1)).save(newCustomer);
	}

	@Test
	public void testUpdate() {
		Long id = 1L;
		Customers returned = savedCustomer;
		Customers update = new Customers("Ben", "Address1", "Number1");
		Customers updated = new Customers(id, update.getName(), update.getAddress(), update.getPhoneNumber());

		Mockito.when(this.repo.save(savedCustomer)).thenReturn(savedCustomer);
		Mockito.when(this.repo.getById(id)).thenReturn(returned);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		Customers result = this.service.updateInfo(id, update);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).save(savedCustomer);
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
		List<Customers> list = new ArrayList<>();
		list.add(savedCustomer);

		Mockito.when(this.repo.findAll()).thenReturn(list);
		assertThat(this.service.readAll()).isEqualTo(list);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadId() {
		Long id = 1L;
		Customers first = new Customers(id, "Alex", "Address", "Number");
		Optional<Customers> optCust = Optional.of(first);
		Customers expected = new Customers(first.getId(), first.getName(), first.getAddress(), first.getPhoneNumber());

		Mockito.when(this.repo.findById(id)).thenReturn(optCust);

		Customers result = this.service.readId(id);

		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

}
