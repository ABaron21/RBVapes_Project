package com.qa.rbvapes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.Brands;

@Repository
public interface BrandRepo extends JpaRepository<Brands, Long> {

}
