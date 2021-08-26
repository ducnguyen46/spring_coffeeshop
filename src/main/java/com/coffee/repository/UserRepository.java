package com.coffee.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coffee.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUsername(String username);

	Optional<User> findById(Long id);

	// Login
	// kiem tra ton tai username va pwd
	@Query(value = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
	List<User> getUserByUsernamePassword(@Param("username") String username, @Param("password") String password);

	// kiem tra ton tai username
	@Query(value = "SELECT u FROM User u WHERE u.username = :username")
	List<User> getUserByUsername(@Param("username") String username);

	// kiem tra ton tai email
	@Query(value = "SELECT u FROM User u WHERE u.email = :email")
	List<User> getUserByEmail(@Param("email") String email);

	// thay doi mat khau
	@Modifying
	@Query(value = "UPDATE User u SET u.password = :password WHERE u.username = :username")
	int updateUserPassword(@Param("username") String username, @Param("password") String password);

	// dang ky
	// save cua Jpa
	@Modifying
	@Query(value = "UPDATE User u SET u.point = :point WHERE u.username = :username")
	int updatePoint(@Param("username") String username, @Param("point") Long point);
	@Modifying
	@Query(value = "UPDATE User u SET u.reward = :reward WHERE u.username = :username")
	int updateReward(@Param("username") String username, @Param("reward") String reward);
}
