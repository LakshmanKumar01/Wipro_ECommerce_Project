package com.wipro.order.service;

import com.wipro.order.entities.OrderEntity;

public interface OrderService {

	OrderEntity placeOrder(Long cartId, String address);

	OrderEntity orderStatus(Long id);

	OrderEntity cancelOrder(Long id);

}
