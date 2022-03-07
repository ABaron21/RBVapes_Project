package com.qa.rbvapes.services;

import java.util.List;
import java.util.Optional;

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
	private FlavourService Fservice;

	public OrderService(OrderRepo repo, BrandRepo Brepo, FlavourRepo Frepo, FlavourService Fservice) {
		super();
		this.repo = repo;
		this.Brepo = Brepo;
		this.Frepo = Frepo;
		this.Fservice = Fservice;
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
		Fservice.updateQtnOrder(newOrder.getFlavourID(), info.getItemQuantity(), "purchase");
		return this.repo.save(newOrder);
	}

	public List<Orders> readAll() {
		return this.repo.findAll();
	}

	public Orders readById(Long id) {
		Optional<Orders> optionalOrder = this.repo.findById(id);
		if (optionalOrder.isPresent()) {
			return optionalOrder.get();
		}
		return null;
	}

	public void delete(Long id) {
		Orders refundedOrder = this.repo.getById(id);
		Fservice.updateQtnOrder(refundedOrder.getFlavourID(), refundedOrder.getItemQuantity(), "refund");
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
