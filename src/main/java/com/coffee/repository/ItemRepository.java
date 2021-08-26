package com.coffee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coffee.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	@Transactional
	@Query(value = "SELECT i FROM Item i, Order o WHERE i.order.id = :orderId")
	List<Item> getItemsByOrderId(@Param("orderId") Long orderId);
	
	@Transactional
	@Query(value = "SELECT i FROM Item i, Order o, User u WHERE i.order.user.username = :username")
	List<Item> getAllItemsOfUser(@Param("username") String username);
}
