package com.web.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.tutor.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
	
}

