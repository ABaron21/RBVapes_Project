package com.qa.rbvapes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.services.OrderService;

@RestController
public class OrderController {

	private OrderService service;

	public OrderController(OrderService service) {
		super();
		this.service = service;
	}

}
