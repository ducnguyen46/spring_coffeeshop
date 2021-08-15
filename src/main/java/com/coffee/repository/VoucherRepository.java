package com.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long>{
	
}
