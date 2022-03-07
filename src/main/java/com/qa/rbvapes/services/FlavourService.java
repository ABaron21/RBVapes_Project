package com.qa.rbvapes.services;

import org.springframework.stereotype.Service;

import com.qa.rbvapes.repos.FlavourRepo;

@Service
public class FlavourService {

	private FlavourRepo repo;

	public FlavourService(FlavourRepo repo) {
		super();
		this.repo = repo;
	}

}
