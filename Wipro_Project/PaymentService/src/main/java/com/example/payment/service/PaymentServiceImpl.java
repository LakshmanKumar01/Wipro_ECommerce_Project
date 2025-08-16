package com.example.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.entity.OrderEntity;
import com.example.payment.entity.PaymentEntity;
import com.example.payment.feign.PaymentFeign;
import com.example.payment.repo.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repo;

	public class PaymentException extends RuntimeException {
		public PaymentException(String message) {
			super(message);
		}
	}

	@Autowired
	private PaymentFeign payfeign;

	@Override
	public PaymentEntity makePayment(Long orderId) {
		try {
			OrderEntity order = payfeign.getOrderById(orderId);
			if (order == null) {
				throw new PaymentException("Not Found");
			}
			PaymentEntity payment = new PaymentEntity();
			payment.setOrderId(orderId);
			payment.setAmount(order.getAmount());
			payment.setStatus("Done!");
			return repo.save(payment);
		} catch (Exception e) {
			throw new PaymentException("Payment failed: " + e.getMessage());
		}
	}

	@Override
	public PaymentEntity getPaymentById(Long id) {
		return repo.findById(id).orElseThrow(() -> new PaymentException("Payment was not Completed"));
	}

}
