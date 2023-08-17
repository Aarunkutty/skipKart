package com.aarun.skipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarun.skipkart.dao.CartDao;
import com.aarun.skipkart.dto.CartDto;

@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	public void saveCart(CartDto cartDto) {
		cartDao.saveCart(cartDto);
	}

}