package com.wipro.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.order.entities.CartEntity;

@FeignClient(name = "CartService")
public interface CartFeign {
	@GetMapping("/api/v1/cart/getCartbyId/{id}")
	CartEntity getCartById(@PathVariable Long id);

	Long getQuantity();
}
