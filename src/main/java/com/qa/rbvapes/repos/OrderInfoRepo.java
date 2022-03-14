package com.qa.rbvapes.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rbvapes.domains.OrderInfo;

@Repository
public interface OrderInfoRepo extends JpaRepository<OrderInfo, Long> {

	List<OrderInfo> findAllByDeliveryDate(LocalDate deliveryDate);

	List<OrderInfo> findAllByDatePlaced(LocalDate datePlaced);
}
