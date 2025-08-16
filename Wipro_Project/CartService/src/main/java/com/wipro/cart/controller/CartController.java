package com.wipro.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.cart.entities.CartEntity;
import com.wipro.cart.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService service;
	
	@PostMapping("/addcart/{id}")
	public CartEntity addCart(@PathVariable Long id,@RequestParam Long quantity) {
		return service.addCart(id,quantity);
	}
	
	@PatchMapping("/updateQuantity/{id}")
	public CartEntity updateCartQuantity(@PathVariable Long id, @RequestParam Long quantity) {
		return service.updateQuantity(id,quantity);
	}
	
	@GetMapping("/getAllProducts")
	public List<CartEntity> getAllProducts(){
		return service.getAllProducts();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProducts(@PathVariable Long id) {
		service.itemDeleted(id);
	}
}
