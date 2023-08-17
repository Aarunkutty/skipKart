package com.aarun.skipkart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.ProductDto;
import com.aarun.skipkart.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;

	public void saveProduct(ProductDto dto) {
		productRepository.save(dto);
		
	}
	
	public List<ProductDto> viewProducts() {
		return productRepository.findAll();
	}

	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}
	public boolean existProductById(int id) {
		return productRepository.existsById(id);
	}
	public void updateProduct(ProductDto dto) {
		productRepository.save(dto);
	}

	public void deleteProducts() {
		productRepository.deleteAll();
		
	}

	public Optional<ProductDto> viewProductById(int id) {
		return productRepository.findById(id);
	}
	
}