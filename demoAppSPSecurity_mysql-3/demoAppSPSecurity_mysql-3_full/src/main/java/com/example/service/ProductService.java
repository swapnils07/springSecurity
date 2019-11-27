package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.entites.Product;
import com.example.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product addNewProduct(Product product) {
		return productRepository.save(product);
	}
	
	/*public List<Product> getAllProduct() {
		return productRepository.findAll();
	}*/
	
	public List<Product> getAllProduct() {
		return productRepository.getAllProduct();
	}

}
