package com.qa.rbvapes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.Customers;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Long> {

}
