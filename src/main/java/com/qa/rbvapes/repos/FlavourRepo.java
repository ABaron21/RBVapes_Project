package com.qa.rbvapes.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.Flavours;

@Repository
public interface FlavourRepo extends JpaRepository<Flavours, Long> {

	List<Flavours> findAllByBrandName(String brandName);
}
