package com.qa.rbvapes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.qa.rbvapes.services.BrandService;

@RestController
public class BrandController {

	private BrandService service;

	public BrandController(BrandService service) {
		super();
		this.service = service;
	}

}
