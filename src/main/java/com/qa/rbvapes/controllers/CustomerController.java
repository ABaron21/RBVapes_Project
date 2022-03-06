package com.qa.rbvapes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.services.CustomerService;

@RestController
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

}
