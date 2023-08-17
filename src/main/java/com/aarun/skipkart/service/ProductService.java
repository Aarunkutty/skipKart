package com.aarun.skipkart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarun.skipkart.dao.ProductDao;
import com.aarun.skipkart.dto.ProductDto;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	public void saveProduct(ProductDto dto) {
		dao.saveProduct(dto);

	}

	public List<ProductDto> viewProducts() {
		return dao.viewProducts();
	}

	public boolean existProductById(int id) {
		return dao.existProductById(id);
	}

	public void deleteProductById(int id) {
		dao.deleteProductById(id);
	}

	public void updateProduct(ProductDto dto) {
		dao.updateProduct(dto);
	}

	public void deleteProducts() {
		dao.deleteProducts();
	}

	public ProductDto viewProductById(int id) {
		if (dao.viewProductById(id).isPresent())
			return dao.viewProductById(id).get();
		return null;
	}

	public ProductDto fetchById(Integer productid) {
		if ( dao.viewProductById(productid).isPresent()) 
		return dao.viewProductById(productid).get();
	return null;
	}

}