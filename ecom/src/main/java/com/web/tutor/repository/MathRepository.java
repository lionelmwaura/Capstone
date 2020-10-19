package com.web.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.tutor.applications.Equation;

@Repository
public interface MathRepository extends JpaRepository<Equation, Long>{
	Equation findByMath(String Math);
}
