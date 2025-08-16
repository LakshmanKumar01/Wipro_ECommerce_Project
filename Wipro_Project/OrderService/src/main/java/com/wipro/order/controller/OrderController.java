package com.wipro.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.order.entities.OrderEntity;
import com.wipro.order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// Placing the order
	@PostMapping("/orderplacement/{cartid}")
	public OrderEntity orderPlaced(@RequestParam Long cartId, @RequestParam String address) {
		return orderService.placeOrder(cartId, address);
	}

	// Status of the order
	@GetMapping("/orderstatus/{id}")
	public OrderEntity orderStatus(@PathVariable Long id) {
		return orderService.orderStatus(id);
	}

	// Cancel the Order
	@PatchMapping("/cancelOrder/{id}")
	public OrderEntity cancelOrder(@PathVariable Long id) {
		return orderService.cancelOrder(id);
	}

}
