package com.wipro.cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.cart.entities.Product;

@FeignClient(name = "ProductServiceImpl", path = "/api/product")
public interface Feign {
	@GetMapping("/getById/{id")
	public Product getProductById(@RequestParam Long id);
}
