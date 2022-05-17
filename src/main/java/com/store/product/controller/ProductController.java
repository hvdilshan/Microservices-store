package com.store.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.store.product.entity.Product;
import com.store.product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//save product to the temporary database
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	//get product by product id
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long productID) {
		return productService.getProductById(productID);
	}
	
	//get all products details as a list
	@GetMapping("/")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	//delete product by id
	@DeleteMapping("/{id}")
	public boolean deleteProductById(@PathVariable("id") Long productID) {
		return productService.deleteProductById(productID);
	}
	
	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
}
