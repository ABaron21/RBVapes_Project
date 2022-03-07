package com.qa.rbvapes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.domains.Brands;
import com.qa.rbvapes.repos.BrandRepo;

@Service
public class BrandService {

	private BrandRepo repo;

	public BrandService(BrandRepo repo) {
		super();
		this.repo = repo;
	}

	public Brands createNew(Brands info) {
		return this.repo.save(info);
	}

	public List<Brands> readAll() {
		return this.repo.findAll();
	}

	public Brands readBrandName(String brandName) {
		return this.repo.findByBrandName(brandName);
	}

	public Brands update(Long id, Brands newInfo) {
		Brands oldInfo = this.repo.getById(id);
		oldInfo.setBrandName(newInfo.getBrandName());
		oldInfo.setPuffCount(newInfo.getPuffCount());
		oldInfo.setPrice(newInfo.getPrice());
		return this.repo.save(oldInfo);
	}

	public void delete(Long id) {
		this.repo.deleteById(id);
	}
}
