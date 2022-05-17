package com.store.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.product.entity.Product;
import com.store.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	public Product getProductById(Long productID) {
		
		return productRepository.findByProductID(productID);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public boolean deleteProductById(Long productID) {
		
		try {
			productRepository.deleteById(productID);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Product updateProduct(Product product) {
		
		Product tempProduct = productRepository.findByProductID(product.getProductID());
		
		tempProduct.setProductName(product.getProductName());
		tempProduct.setProcuctDescription(product.getProcuctDescription());
		tempProduct.setUnitPrice(product.getUnitPrice());
		
		return productRepository.save(tempProduct);
	}
}
