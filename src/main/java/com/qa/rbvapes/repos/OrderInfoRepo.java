package com.qa.rbvapes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.OrderInfo;

@Repository
public interface OrderInfoRepo extends JpaRepository<OrderInfo, Long> {

}
