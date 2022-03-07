package com.qa.rbvapes.services;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.repos.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;

	public CustomerService(CustomerRepo repo) {
		super();
		this.repo = repo;
	}

}
