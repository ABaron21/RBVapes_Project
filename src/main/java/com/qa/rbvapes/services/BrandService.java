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
}
