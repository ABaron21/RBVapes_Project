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

	public List<OrderInfo> readDelivery(String dDate) {
		return this.repo.findAllByDeliveryDate(dDate);
	}

	public List<OrderInfo> readDatePlaced(String dateP) {
		return this.repo.findAllByDatePlaced(dateP);
	}

	public OrderInfo update(Long id, OrderInfo newInfo) {
		OrderInfo oldInfo = this.repo.getById(id);
		oldInfo.setCustomerID(newInfo.getCustomerID());
		oldInfo.setOrderID(newInfo.getOrderID());
		oldInfo.setDatePlaced(newInfo.getDatePlaced());
		oldInfo.setDeliveryDate(newInfo.getDeliveryDate());
		return this.repo.save(oldInfo);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
