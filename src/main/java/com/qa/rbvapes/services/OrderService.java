package com.qa.rbvapes.services;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.repos.OrderRepo;

@Service
public class OrderService {

	private OrderRepo repo;

	public OrderService(OrderRepo repo) {
		super();
		this.repo = repo;
	}

}
