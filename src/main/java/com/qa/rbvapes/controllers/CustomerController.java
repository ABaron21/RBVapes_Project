package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.domains.Customers;
import com.qa.rbvapes.services.CustomerService;

@RestController
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Customers createCustomer(@RequestBody Customers info) {
		return this.service.createNew(info);
	}

	@GetMapping("/readAll")
	public List<Customers> readAll() {
		return this.service.readAll();
	}
}
