package com.qa.rbvapes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.domains.Flavours;
import com.qa.rbvapes.repos.FlavourRepo;

@Service
public class FlavourService {

	private FlavourRepo repo;

	public FlavourService(FlavourRepo repo) {
		super();
		this.repo = repo;
	}

	public Flavours createNew(Flavours flavour) {
		return this.repo.save(flavour);
	}

	public List<Flavours> readAll() {
		return this.repo.findAll();
	}

	public List<Flavours> readFlavours(String brandName) {
		return this.repo.findAllByBrandName(brandName);
	}

	public Flavours updateInfo(Long id, Flavours newInfo) {
		Flavours oldInfo = this.repo.getById(id);
		oldInfo.setFlavourName(newInfo.getFlavourName());
		oldInfo.setBrandName(newInfo.getBrandName());
		oldInfo.setQuantity(newInfo.getQuantity());
		return this.repo.save(oldInfo);
	}

//	public void updateQtnOrder(Long id, int itemAmount, String type) {
//		Flavours oldAmount = this.repo.getById(id);
//		int newAmount;
//		if (type.equals("purchase")) {
//			newAmount = oldAmount.getQuantity() - itemAmount;
//			oldAmount.setQuantity(newAmount);
//			this.repo.save(oldAmount);
//		} else if (type.equals("refund")) {
//			newAmount = oldAmount.getQuantity() + itemAmount;
//			oldAmount.setQuantity(newAmount);
//			this.repo.save(oldAmount);
//		}
//	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
