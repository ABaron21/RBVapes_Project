package com.qa.rbvapes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

	@Query(value = "SELECT * FROM ORDERS ORDER BY ID DESC LIMIT 1", nativeQuery = true)
	public Orders getLastResult();
}
