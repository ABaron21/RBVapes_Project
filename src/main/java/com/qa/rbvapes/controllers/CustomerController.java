package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/readById/{id}")
	public Customers readById(@PathVariable Long id) {
		return this.service.readId(id);
	}

	@PutMapping("/update/{id}")
	public Customers updateCustomer(@PathVariable Long id, @RequestBody Customers newInfo) {
		return this.service.updateInfo(id, newInfo);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		this.service.delete(id);
	}
}
