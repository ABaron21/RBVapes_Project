package com.qa.rbvapes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.services.FlavourService;

@RestController
public class FlavourController {

	private FlavourService service;

	public FlavourController(FlavourService service) {
		super();
		this.service = service;
	}

}
