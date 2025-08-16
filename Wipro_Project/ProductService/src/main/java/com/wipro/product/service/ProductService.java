package com.wipro.product.service;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import com.wipro.product.entity.Product;

public interface ProductService {

	Product add(Product products);

	Product get(Long id);

	Product updateProduct(Long id, Product partialProduct);

	void delete(Long id);

	Page<Product> getByCategory(Pageable pageable);

	Product getProductById(Long id);

}
