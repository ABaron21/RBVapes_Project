package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/readOrderById/{id}")
	public Orders readOrderById(@PathVariable Long id) {
		return this.service.readById(id);
	}

	@PutMapping("/updateOrder/{Id}")
	public Orders updateOrder(@PathVariable Long Id, @RequestBody Orders newInfo) {
		return this.service.update(Id, newInfo);
	}

	@DeleteMapping("/deleteOrder/{id}")
	public void deleteOrder(@PathVariable Long id) {
		this.service.delete(id);
	}

}
