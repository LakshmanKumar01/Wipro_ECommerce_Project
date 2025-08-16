package com.example.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.entity.PaymentEntity;
import com.example.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService service;

	@PostMapping("/payment/{orderId}")
	public PaymentEntity payment(@PathVariable Long orderId) {
		return service.makePayment(orderId);
	}

	@GetMapping("/getPayment/{id}")
	public PaymentEntity getPaymentId(@PathVariable Long id) {
		return service.getPaymentById(id);
	}
}
