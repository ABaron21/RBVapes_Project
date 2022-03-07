package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.domains.Orders;
import com.qa.rbvapes.services.OrderService;

@RestController
public class OrderController {

	private OrderService service;

	public OrderController(OrderService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createOrder")
	public Orders createOrder(@RequestBody Orders info) {
		return this.service.createNew(info);
	}

	@GetMapping("/readAllOrders")
	public List<Orders> readAllOrder() {
		return this.service.readAll();
	}

}
