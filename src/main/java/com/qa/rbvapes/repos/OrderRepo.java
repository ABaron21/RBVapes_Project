package com.qa.rbvapes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

}
