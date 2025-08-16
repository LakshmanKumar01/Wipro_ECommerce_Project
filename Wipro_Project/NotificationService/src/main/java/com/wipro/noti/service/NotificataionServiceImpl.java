package com.wipro.noti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.noti.entities.Payments;
import com.wipro.noti.feign.PaymentInter;

@Service

public class NotificataionServiceImpl implements NotificationService {

	@Autowired
	private PaymentInter payInter;

	@Override
	public String showOrderMessage(Long paymentId) {
		Payments payment = payInter.getPaymentById(paymentId);
		if (payment != null && "Success".equalsIgnoreCase(payment.getStatus())) {
			return "Order Placed Successfully";
		} else {
			return "Failed";
		}
	}

}
