package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.entity.DeliveryInfo;
import com.coffee.entity.User;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Long>{
	
	@Query(value = "SELECT d FROM DeliveryInfo d, User u WHERE d.user.username = :username AND d.isDefault = 'true'")
	List<DeliveryInfo>getDeliveryInfoByUsername(@Param("username") String username);
	
	@Transactional
	@Query(value = "UPDATE DeliveryInfo d SET d.isDefault = 'false' "
			+ "WHERE d.id = :id ")
	int deleteDeliveryInfo(@Param("id") Long id);
}
