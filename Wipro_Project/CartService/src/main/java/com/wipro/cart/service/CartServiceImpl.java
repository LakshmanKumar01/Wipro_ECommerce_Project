package com.wipro.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.cart.entities.CartEntity;
import com.wipro.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository repo;

	@Override
	public CartEntity addCart(Long id, Long quantity) {
		CartEntity existCart = repo.findById(id).orElse(new CartEntity());
		existCart.setProductId(id);
		return repo.save(existCart);
	}

	@Override
	public CartEntity updateQuantity(Long id, Long quantity) {
		CartEntity cart = repo.findById(id).orElseThrow();
		cart.setQuantity(quantity);
		return repo.save(cart);
	}

	@Override
	public List<CartEntity> getAllProducts() {
		return repo.findAll().stream()
				.map(cart -> new CartEntity(cart.getProductId(), cart.getQuantity(), cart.getPrice())).toList();
	}

	@Override
	public void itemDeleted(Long id) {
		repo.deleteById(id);
	}

}
