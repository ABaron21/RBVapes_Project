package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/createCustomer")
	public ResponseEntity<Customers> createCustomer(@RequestBody Customers info) {
		return new ResponseEntity<>(this.service.createNew(info), HttpStatus.CREATED);
	}

	@GetMapping("/readAllCustomers")
	public ResponseEntity<List<Customers>> readAll() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/readCustomerById/{id}")
	public ResponseEntity<Customers> readById(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.readId(id), HttpStatus.FOUND);
	}

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @RequestBody Customers newInfo) {
		return new ResponseEntity<>(this.service.updateInfo(id, newInfo), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
}
