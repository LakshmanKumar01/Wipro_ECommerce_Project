package com.example.payment.service;

import org.springframework.stereotype.Service;

import com.example.payment.entity.PaymentEntity;

@Service
public interface PaymentService {

	PaymentEntity makePayment(Long orderId);

	PaymentEntity getPaymentById(Long id);

}
