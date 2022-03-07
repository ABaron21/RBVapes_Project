package com.qa.rbvapes.services;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.domains.OrderInfo;
import com.qa.rbvapes.repos.OrderInfoRepo;

@Service
public class OrderInfoService {

	private OrderInfoRepo repo;

	public OrderInfoService(OrderInfoRepo repo) {
		super();
		this.repo = repo;
	}

	public OrderInfo create(OrderInfo info) {
		return this.repo.save(info);
	}

}
