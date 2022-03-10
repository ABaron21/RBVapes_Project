package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Brands> create(@RequestBody Brands info) {
		return new ResponseEntity<>(this.service.createNew(info), HttpStatus.CREATED);
	}

	@GetMapping("/readAllBrands")
	public ResponseEntity<List<Brands>> readAllBrands() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/readByBrandName/{brandName}")
	public ResponseEntity<Brands> readByBrandName(@PathVariable String brandName) {
		return new ResponseEntity<>(this.service.readBrandName(brandName), HttpStatus.FOUND);
	}

	@PutMapping("/updateBrand/{id}")
	public ResponseEntity<Brands> updateBrand(@PathVariable int id, @RequestBody Brands newInfo) {
		return new ResponseEntity<>(this.service.update(id, newInfo), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteBrand/{id}")
	public ResponseEntity<Object> deleteBrand(@PathVariable int id) {
		return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
}
