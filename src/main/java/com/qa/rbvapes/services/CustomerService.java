package com.qa.rbvapes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.domains.Customers;
import com.qa.rbvapes.repos.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;

	public CustomerService(CustomerRepo repo) {
		super();
		this.repo = repo;
	}

	public Customers createNew(Customers Info) {
		return this.repo.save(Info);
	}

	public List<Customers> readAll() {
		return this.repo.findAll();
	}

	public Customers updateInfo(Long id, Customers newInfo) {
		Customers oldInfo = this.repo.getById(id);
		oldInfo.setName(newInfo.getName());
		oldInfo.setAddress(newInfo.getAddress());
		oldInfo.setPhoneNumber(newInfo.getPhoneNumber());
		return this.repo.save(oldInfo);
	}

	public void delete(Long id) {
		this.repo.deleteById(id);
	}
}
