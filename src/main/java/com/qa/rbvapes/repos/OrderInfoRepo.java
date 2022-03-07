package com.qa.rbvapes.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.OrderInfo;

@Repository
public interface OrderInfoRepo extends JpaRepository<OrderInfo, Long> {

	List<OrderInfo> findAllByDeliveryDate(String deliveryDate);

	List<OrderInfo> findAllByDatePlaced(String datePlaced);
}
