package com.wipro.product.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.product.entity.Product;
import com.wipro.product.repo.ProductRepository;
import com.wipro.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductRepository productRepository;
	@Autowired
	private ProductService service;

    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	@PostMapping("/addproducts")
	public Product addProducts(@RequestParam Product products) {
		return service.add(products);
	}

	@GetMapping("/getByID/{id}")
	public Product get(@PathVariable Long id) {
		return service.get(id);

	}
	
	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable Long id) {
		return service.getProductById(id);
	}

	@GetMapping("/getByCategory")
	public Page<Product> category(Pageable pageable) {
		return service.getByCategory(pageable);
	}

	@PatchMapping("/UpdateProduct/{id}")
	public Product patchUpdate(@PathVariable Long id, @RequestBody Product partialProduct) {
		return service.updateProduct(id, partialProduct);
	}

	@DeleteMapping("/DeleteById/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "product deleted successfully";

	}
}
