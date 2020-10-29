package com.web.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.tutor.applications.Equation;


public interface MathRepository extends JpaRepository<Equation, Long> {
	
	
	
	Equation findByMath(String math);
	Equation findById(long id);
}
