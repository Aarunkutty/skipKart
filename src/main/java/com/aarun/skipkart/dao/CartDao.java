package com.aarun.skipkart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.CartDto;
import com.aarun.skipkart.repository.CartRepository;

@Repository
public class CartDao {

	@Autowired
	CartRepository cartRepository;

	public void saveCart(CartDto cartDto) {
		cartRepository.save(cartDto);
	}
	
	
}