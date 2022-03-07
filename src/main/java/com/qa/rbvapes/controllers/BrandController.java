package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.domains.Brands;
import com.qa.rbvapes.services.BrandService;

@RestController
public class BrandController {

	private BrandService service;

	public BrandController(BrandService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createBrand")
	public Brands create(@RequestBody Brands info) {
		return this.service.createNew(info);
	}

	@GetMapping("/readAllBrands")
	public List<Brands> readAllBrands() {
		return this.service.readAll();
	}

	@GetMapping("/readByBrandName/{brandName}")
	public Brands readByBrandName(@PathVariable String brandName) {
		return this.service.readBrandName(brandName);
	}

	@PutMapping("/updateBrand/{id}")
	public Brands updateBrand(@PathVariable int id, @RequestBody Brands newInfo) {
		return this.service.update(id, newInfo);
	}

	@DeleteMapping("/deleteBrand/{id}")
	public void deleteBrand(@PathVariable int id) {
		this.service.delete(id);
	}
}
