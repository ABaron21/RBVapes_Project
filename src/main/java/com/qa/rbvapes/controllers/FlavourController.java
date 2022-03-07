package com.qa.rbvapes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.domains.Flavours;
import com.qa.rbvapes.services.FlavourService;

@RestController
public class FlavourController {

	private FlavourService service;

	public FlavourController(FlavourService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createFlavour")
	public Flavours createFlavour(@RequestBody Flavours flavour) {
		return this.service.createNew(flavour);
	}

	@GetMapping("/readAllFlavours")
	public List<Flavours> readAllFlavours() {
		return this.service.readAll();
	}

	@GetMapping("/readFlavoursByBrand/{brandName}")
	public List<Flavours> readByBrand(@PathVariable String brandName) {
		return this.service.readFlavours(brandName);
	}

	@PutMapping("/updateFlavour/{id}")
	public Flavours updateFlavour(@PathVariable Long id, @RequestBody Flavours newInfo) {
		return this.service.updateInfo(id, newInfo);
	}

	@DeleteMapping("/deleteFlavour/{id}")
	public void deleteFlavour(@PathVariable Long id) {
		this.service.delete(id);
	}
}
