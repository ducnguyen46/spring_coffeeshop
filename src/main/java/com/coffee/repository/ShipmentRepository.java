package com.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Shipment sh SET sh.isCompleted = 'true' WHERE sh.order.id = :orderId")
	public int orderCompleted(@Param("orderId") Long orderId);
}
