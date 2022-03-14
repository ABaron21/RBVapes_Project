package com.qa.rbvapes.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.domains.Customers;
import com.qa.rbvapes.domains.OrderInfo;
import com.qa.rbvapes.repos.CustomerRepo;
import com.qa.rbvapes.repos.OrderInfoRepo;

@Service
public class OrderInfoService {

	private LocalDate date = LocalDate.now();

	private OrderInfoRepo repo;
	private CustomerRepo Crepo;

	public OrderInfoService(OrderInfoRepo repo, CustomerRepo Crepo) {
		super();
		this.repo = repo;
		this.Crepo = Crepo;
	}

	public OrderInfo create(OrderInfo info) {
		return this.repo.save(info);
	}

	public OrderInfo createInfo(Long cID, Long oID) {
		Customers customer = this.Crepo.getById(cID);
		OrderInfo newInfo = new OrderInfo();
		newInfo.setCustomerID(customer.getId());
		newInfo.setOrderID(oID);
		newInfo.setDatePlaced(date);
		newInfo.setDeliveryDate(date.plus(3, ChronoUnit.DAYS));
		return this.repo.save(newInfo);
	}

	public List<OrderInfo> readAll() {
		return this.repo.findAll();
	}

	public List<OrderInfo> readDelivery(LocalDate dDate) {
		return this.repo.findAllByDeliveryDate(dDate);
	}

	public List<OrderInfo> readDatePlaced(LocalDate dateP) {
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
