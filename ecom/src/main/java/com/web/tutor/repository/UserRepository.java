package com.web.tutor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.tutor.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	String search="SELECT u FROM Users u WHERE u.email =:email AND " +
		    "u.fName LIKE (CONCAT('%',:name, '%')) OR u.lName =:name";
	
	Optional<Users> findByEmail(String email);
	
	@Query("FROM Users u WHERE u.email=?1 AND u.password=?2")
	Optional<Users> login(String email, String password);
	
	@Query("FROM Users WHERE lName=?1 OR fName=?1 OR email=?1")
	List<Users> findByName(String name);
	
	@Query("FROM Users WHERE lName=?1 AND email=?1")
	List<Users> findByNameAndEmail(String name);
	
	
	
}
