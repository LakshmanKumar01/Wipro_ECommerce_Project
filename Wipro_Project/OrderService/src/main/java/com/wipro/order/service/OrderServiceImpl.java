package com.wipro.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.order.entities.CartEntity;
import com.wipro.order.entities.OrderEntity;
import com.wipro.order.feign.CartFeign;
import com.wipro.order.repo.OrderRepsitory;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepsitory repo;

//	@Autowired
	// FeignClient
	private CartFeign feign;

	public class OrderException extends RuntimeException {
		public OrderException(String message) {
			super(message);
		}
	}

	@Override
	public OrderEntity placeOrder(Long cartId, String address) {
		CartEntity cartEnt = feign.getCartById(cartId);
		if (cartEnt == null) {
			throw new OrderException("No Order for Found");
		}
		OrderEntity order = new OrderEntity();
		order.setCartId(cartId);
		order.setAddress(address);
		order.setStatus("Order Placed");
		order.setAmount(cartEnt.getProductId() * feign.getQuantity());
		return repo.save(order);
	}

	@Override
	public OrderEntity orderStatus(Long id) {
		return repo.findById(id).orElseThrow(() -> new OrderException("Order Not Found"));
	}

	@Override
	public OrderEntity cancelOrder(Long id) {
		OrderEntity order = repo.findById(id).orElseThrow(() -> new OrderException("Order not found"));
		order.setStatus("Order Cancelled");
		return repo.save(order);
	}

}
