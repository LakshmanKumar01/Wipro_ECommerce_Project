package com.wipro.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.cart.entities.CartEntity;

@Service
public interface CartService {

	CartEntity addCart(Long id, Long quantity);

	CartEntity updateQuantity(Long id, Long quantity);

	List<CartEntity> getAllProducts();

	void itemDeleted(Long id);


}
