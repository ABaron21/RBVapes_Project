package com.qa.rbvapes.controllers;

import org.springframework.web.bind.annotation.PostMapping;
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

}
