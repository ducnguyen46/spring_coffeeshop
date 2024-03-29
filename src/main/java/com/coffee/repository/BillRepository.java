package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{
	
	@Transactional
	@Query(value = "SELECT b FROM Bill b, Order o, User u WHERE b.order.id = o.id AND o.user.username = :username")
	List<Bill> findByUser(@Param("username") String username);
	
	@Transactional
	@Query(value = "SELECT b FROM Bill b, Order o, User u WHERE b.order.id = o.id AND o.shipment.isCompleted = 'false' AND o.user.username = :username")
	List<Bill> getAllBillOnGoing(@Param("username") String username);
	
	@Transactional
	@Query(value = "SELECT b FROM Bill b, Order o, User u WHERE b.order.id = o.id AND o.shipment.isCompleted = 'true' AND o.user.username = :username")
	List<Bill> getAllBillComplete(@Param("username") String username);
	
}
