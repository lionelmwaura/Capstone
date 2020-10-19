package com.web.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.tutor.model.Addressess;

@Repository
public interface AddressRepository extends JpaRepository<Addressess, Long> {
	Addressess findByEmail(String email);
}

