package com.aarun.skipkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.aarun.skipkart.dto.CartDto;
import com.aarun.skipkart.dto.ConsumerDto;
import com.aarun.skipkart.dto.ItemDto;
import com.aarun.skipkart.service.CartService;
import com.aarun.skipkart.service.ConsumerService;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;

	@Autowired
	CartService cartService;

	@PostMapping("/signup")
	public void createConsumer(@RequestBody ConsumerDto consumerDTO) {
		CartDto  cartDto = new CartDto();
		cartService.saveCart(cartDto);
		consumerDTO.setCart(cartDto);
		consumerService.createConsumer(consumerDTO);
	}

	@PostMapping("/signin/{consumeremail}/{consumerpassword}")
	public ConsumerDto consumerLogIn(String consumeremail, long consumerpassword) {
		return consumerService.consumerLogIn(consumeremail, consumerpassword);
	}

	@GetMapping("/fetchconsumer/{consumerid}")
	public ConsumerDto fetchById(@PathVariable Integer consumerid) {
		return consumerService.findById(consumerid);

	}

	@PostMapping("/additemtocart/{consumerId}/{productId}/{quantity}")
	public void addItemToCart(@PathVariable int consumerId, @PathVariable int productId, @PathVariable int quantity) {
		consumerService.addItemToCart(consumerId,productId,quantity);
	}
	
	@PostMapping("/addproducttocart/{consumerId}/{productId}/{quantity}")//vasudha
	public void addProductToCart(@PathVariable int consumerId, @PathVariable int productId, @PathVariable int quantity) {
		consumerService.addProductToCart(consumerId,productId,quantity);
	}
	
	@DeleteMapping("/deleteitembyid/{itemId}")
	public void deleteById(@PathVariable int itemId) {
		consumerService.deleteById(itemId);
	}
	@GetMapping("/viewitems/{customerid}")
	public List<ItemDto> viewItems(@PathVariable int customerid) {
		return consumerService.viewCartItem(customerid);
	}
	
	@PutMapping("/saveforlater/{itemid}")
	public void itemSaveForLater(@PathVariable int itemid) {
		consumerService.itemSaveForLater(itemid);
		
	}
	
	@PutMapping("/movetocart/{itemid}")
	public void itemMoveToCart(@PathVariable int itemid) {
		consumerService.itemMoveToCart(itemid);
		
	}
}
