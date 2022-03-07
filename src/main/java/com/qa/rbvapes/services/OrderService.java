package com.qa.rbvapes.services;

import java.util.List;

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
		newOrder.setOrderPrice(priceCalc(info.getItemQuantity(), info.getBrandID()));
		return this.repo.save(newOrder);
	}

	public List<Orders> readAll() {
		return this.repo.findAll();
	}

	public void delete(Long id) {
		this.repo.deleteById(id);
	}

	public double priceCalc(int ItemAmount, int BrandID) {
		double price;
		switch (BrandID) {
		case 1:
			price = ItemAmount * 15;
			return price;
		case 6:
			price = ItemAmount * 10;
			return price;
		case 7:
			price = ItemAmount * 5;
			return price;
		default:
			return 0;

		}
	}

}
