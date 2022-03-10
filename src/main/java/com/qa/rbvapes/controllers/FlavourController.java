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
	public ResponseEntity<Flavours> createFlavour(@RequestBody Flavours flavour) {
		return new ResponseEntity<>(this.service.createNew(flavour), HttpStatus.CREATED);
	}

	@GetMapping("/readAllFlavours")
	public ResponseEntity<List<Flavours>> readAllFlavours() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/readFlavoursByBrand/{brandName}")
	public ResponseEntity<List<Flavours>> readByBrand(@PathVariable String brandName) {
		return new ResponseEntity<>(this.service.readFlavours(brandName), HttpStatus.OK);
	}

	@PutMapping("/updateFlavour/{id}")
	public ResponseEntity<Flavours> updateFlavour(@PathVariable Long id, @RequestBody Flavours newInfo) {
		return new ResponseEntity<>(this.service.updateInfo(id, newInfo), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteFlavour/{id}")
	public ResponseEntity<Object> deleteFlavour(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
}
