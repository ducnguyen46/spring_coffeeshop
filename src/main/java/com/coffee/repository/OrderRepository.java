package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coffee.entity.Order;
import com.coffee.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByUser(User user);
	
	@Modifying
	@Query(value = "UPDATE Order o SET o.shipment.isCompleted = 'true' WHERE o.id = :orderId")
	int completeOrder(@Param("orderId") Long orderId);
	
}
