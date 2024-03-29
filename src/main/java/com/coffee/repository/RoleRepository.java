package com.coffee.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coffee.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findById(Long id);
}
