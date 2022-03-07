package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.domains.OrderInfo;
import com.qa.rbvapes.services.OrderInfoService;

@RestController
public class OrderInfoController {

	private OrderInfoService service;

	public OrderInfoController(OrderInfoService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createOrderInfo")
	public OrderInfo createInfo(@RequestBody OrderInfo info) {
		return this.service.create(info);
	}

	@GetMapping("/readAllInfo")
	public List<OrderInfo> readAllInfo() {
		return this.service.readAll();
	}

	@PutMapping("/updateInfo/{id}")
	public OrderInfo updateInfo(@PathVariable Long id, @RequestBody OrderInfo newInfo) {
		return this.service.update(id, newInfo);
	}

	@DeleteMapping("/deleteInfo/{id}")
	public void deleteInfo(@PathVariable Long id) {
		this.service.delete(id);
	}

}
