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
	public ResponseEntity<Orders> createOrder(@RequestBody Orders info) {
		return new ResponseEntity<>(this.service.createNew(info), HttpStatus.CREATED);
	}

	@GetMapping("/readAllOrders")
	public ResponseEntity<List<Orders>> readAllOrder() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/readOrderById/{id}")
	public ResponseEntity<Orders> readOrderById(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.readById(id), HttpStatus.FOUND);
	}

	@PutMapping("/updateOrder/{Id}")
	public ResponseEntity<Orders> updateOrder(@PathVariable Long Id, @RequestBody Orders newInfo) {
		return new ResponseEntity<>(this.service.update(Id, newInfo), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

}
