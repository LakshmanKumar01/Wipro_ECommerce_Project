package com.example.payment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.payment.entity.OrderEntity;

@FeignClient(name = "OrderService")
public interface PaymentFeign {
	@GetMapping("/api/order/getStatus/{id}")
	OrderEntity getOrderById(@PathVariable Long id);
}
