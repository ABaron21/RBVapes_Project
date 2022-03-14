package com.qa.rbvapes.controllers;

import java.time.LocalDate;
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
	public ResponseEntity<OrderInfo> createInfo(@RequestBody OrderInfo info) {
		return new ResponseEntity<>(this.service.create(info), HttpStatus.CREATED);
	}

	@GetMapping("/readAllInfo")
	public ResponseEntity<List<OrderInfo>> readAllInfo() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/readByDelivery/{Ddate}")
	public ResponseEntity<List<OrderInfo>> readByDelivery(@PathVariable String Ddate) {
		return new ResponseEntity<>(this.service.readDelivery(LocalDate.parse(Ddate)), HttpStatus.FOUND);
	}

	@GetMapping("/readByDatePlaced/{dateP}")
	public ResponseEntity<List<OrderInfo>> readByPlacement(@PathVariable String dateP) {
		return new ResponseEntity<>(this.service.readDatePlaced(LocalDate.parse(dateP)), HttpStatus.FOUND);
	}

	@PutMapping("/updateInfo/{id}")
	public ResponseEntity<OrderInfo> updateInfo(@PathVariable Long id, @RequestBody OrderInfo newInfo) {
		return new ResponseEntity<>(this.service.update(id, newInfo), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteInfo/{id}")
	public ResponseEntity<Object> deleteInfo(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

}
