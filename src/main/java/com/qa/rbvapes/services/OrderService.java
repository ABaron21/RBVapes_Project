package com.qa.rbvapes.services;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.domains.Brands;
import com.qa.rbvapes.domains.Flavours;
import com.qa.rbvapes.domains.Orders;
import com.qa.rbvapes.repos.BrandRepo;
import com.qa.rbvapes.repos.FlavourRepo;
import com.qa.rbvapes.repos.OrderRepo;

@Service
public class OrderService {

	private OrderRepo repo;
	private BrandRepo Brepo;
	private FlavourRepo Frepo;

	public OrderService(OrderRepo repo, BrandRepo Brepo, FlavourRepo Frepo) {
		super();
		this.repo = repo;
		this.Brepo = Brepo;
		this.Frepo = Frepo;
	}

	public Orders createNew(Orders info) {
		Brands brand = this.Brepo.getById(info.getBrandID());
		Flavours flavour = this.Frepo.getById(info.getFlavourID());
		Orders newOrder = new Orders();
		newOrder.setBrandID(info.getBrandID());
		newOrder.setBrandName(brand.getBrandName());
		newOrder.setFlavourID(info.getFlavourID());
		newOrder.setFlavourName(flavour.getFlavourName());
		newOrder.setItemQuantity(info.getItemQuantity());
		newOrder.setOrderPrice(info.getOrderPrice());
		return this.repo.save(newOrder);
	}

}
