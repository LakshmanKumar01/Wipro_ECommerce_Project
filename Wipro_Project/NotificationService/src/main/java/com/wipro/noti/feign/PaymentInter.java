package com.wipro.noti.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.noti.entities.Payments;

@FeignClient(name = "PaymentService")
public interface PaymentInter {
	@GetMapping("/api/payment/getPaymentId/{id}")

	Payments getPaymentById(@PathVariable Long id);
}
