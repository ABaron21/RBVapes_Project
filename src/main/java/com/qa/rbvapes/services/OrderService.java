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
	private OrderInfoService infoService;

	public OrderService(OrderRepo repo, BrandRepo Brepo, FlavourRepo Frepo, FlavourService Fservice,
			OrderInfoService infoService) {
		super();
		this.repo = repo;
		this.Brepo = Brepo;
		this.Frepo = Frepo;
		this.Fservice = Fservice;
		this.infoService = infoService;
	}

	public Orders createNew(Long id, Orders info) {
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
		orderInfo(id);
		return this.repo.save(newOrder);
	}

	public void orderInfo(Long id) {
		Long oID = this.repo.getLastResult().getId();
		infoService.createInfo(id, oID);
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

	public Orders update(Long id, Orders newInfo) {
		Orders oldInfo = this.repo.getById(id);
		Brands brand = this.Brepo.getById(newInfo.getBrandID());
		Flavours flavour = this.Frepo.getById(newInfo.getFlavourID());
		Fservice.updateQtnOrder(oldInfo.getFlavourID(), oldInfo.getItemQuantity(), "refund");
		oldInfo.setBrandID(newInfo.getBrandID());
		oldInfo.setBrandName(brand.getBrandName());
		oldInfo.setFlavourID(newInfo.getFlavourID());
		oldInfo.setFlavourName(flavour.getFlavourName());
		oldInfo.setItemQuantity(newInfo.getItemQuantity());
		oldInfo.setOrderPrice(priceCalc(newInfo.getItemQuantity(), newInfo.getBrandID()));
		Fservice.updateQtnOrder(newInfo.getFlavourID(), newInfo.getItemQuantity(), "purchase");
		return this.repo.save(oldInfo);
	}

	public boolean delete(Long id) {
		Orders refundedOrder = this.repo.getById(id);
		Fservice.updateQtnOrder(refundedOrder.getFlavourID(), refundedOrder.getItemQuantity(), "refund");
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public double priceCalc(int itemAmount, int BrandID) {
		double price = 0;
		int deal = itemAmount / 3;
		int rem = itemAmount % 3;
		double dealAroma = 35.0;
		double dealElux = 25.0;
		double dealElf = 12.0;

		switch (BrandID) {
		case 1:
			if (itemAmount >= 3) {
				price += deal * dealAroma;
				price += rem * 15;
			} else {
				price += 15 * itemAmount;
			}
			return price;
		case 2:
			if (itemAmount >= 3) {
				price += deal * dealElux;
				price += rem * 10;
			} else {
				price += 10 * itemAmount;
			}
			return price;
		case 3:
			if (itemAmount >= 3) {
				price += deal * dealElf;
				price += rem * 5;
			} else {
				price += 5 * itemAmount;
			}
			return price;
		default:
			return 0;

		}
	}

}
