package com.qa.rbvapes.services;

import java.util.List;

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

	public List<OrderInfo> readAll() {
		return this.repo.findAll();
	}

}
