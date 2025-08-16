package com.example.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payment.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
