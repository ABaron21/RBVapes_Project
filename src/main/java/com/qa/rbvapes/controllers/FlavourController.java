package com.qa.rbvapes.controllers;

import org.springframework.web.bind.annotation.PostMapping;
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

}
