package com.wipro.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.product.entity.Product;
import com.wipro.product.exception.ProductNotFoundException;
import com.wipro.product.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	public class ProductException extends RuntimeException {

		public ProductException(String message) {
			super(message);
		}

	}

	@Autowired
	private ProductRepository repo;

	@Override
	public Product add(Product products) {
		return repo.save(products);
	}

	@Override
	public Page<Product> getByCategory(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Product get(Long id) {
		return repo.findById(id).orElseThrow(() -> new ProductException("Not Found"));
	}

	@Override
	public Product updateProduct(Long id, Product partialProduct) {
		Product existing = repo.findById(id).orElseThrow(() -> new ProductException("Product not found"));

		if (partialProduct.getProductName() != null)
			existing.setProductName(partialProduct.getProductName());

		if (partialProduct.getProductCategory() != null)
			existing.setProductCategory(partialProduct.getProductCategory());

		if (partialProduct.getProductPrice() != 0)
			existing.setProductPrice(partialProduct.getProductPrice());

		if (partialProduct.getProductQuantity() != 0)
			existing.setProductQuantity(partialProduct.getProductQuantity());

		return repo.save(existing);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Product getProductById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product outof Stock"));
	}

}
