package com.example.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entites.Product;
import com.example.entites.Users;
import com.example.service.ProductService;
import com.example.util.MyResponse;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public MyResponse<Product> addNewProduct(@RequestBody Product product){
		Product savedProduct=productService.addNewProduct(product);
		MyResponse<Product> myResp=new MyResponse<Product>();
		myResp.setStatus(200);
		myResp.setMessage("Product added Sucess");
		myResp.setData(savedProduct);
		return myResp;
	}
	
	@GetMapping("/products")
	public MyResponse<List<Product>> getAllProducts(){
		List<Product> userList=productService.getAllProduct();
		MyResponse<List<Product>> myResp=new MyResponse<List<Product>>();
		myResp.setStatus(200);
		myResp.setMessage("Product List Sucess");
		myResp.setData(userList);
		return myResp;
	}
}
