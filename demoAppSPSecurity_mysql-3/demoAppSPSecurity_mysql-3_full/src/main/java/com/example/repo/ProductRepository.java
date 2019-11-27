package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	//@Query("select a from Product a")
	@Query("select a from Product a where a.isAvailable=TRUE")
	List<Product> getAllProduct();

}
