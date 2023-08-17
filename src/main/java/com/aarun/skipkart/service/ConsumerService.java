package com.aarun.skipkart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarun.skipkart.dao.ConsumerDao;
import com.aarun.skipkart.dto.CartDto;
import com.aarun.skipkart.dto.ConsumerDto;
import com.aarun.skipkart.dto.ItemDto;
import com.aarun.skipkart.dto.ProductDto;

@Service
public class ConsumerService {

	@Autowired
	ConsumerDao consumerDao;

	@Autowired
	ProductService productService;

	@Autowired
	ItemService itemService;

	@Autowired
	CartService cartService;

	public void createConsumer(ConsumerDto consumerDto) {
		consumerDao.createConsumer(consumerDto);
	}

	public ConsumerDto findById(int customerid) {
		if (consumerDao.findById(customerid).isPresent()) {
			return consumerDao.findById(customerid).get();
		}
		return null;
	}

	public void deleteById(int customerid) {
		consumerDao.deleteById(customerid);
	}

	public ConsumerDto consumerLogIn(String consumeremail, long consumerpassword) {
		return consumerDao.consumerLogIn(consumeremail, consumerpassword);
	}

	public void addItemToCart(int consumerId, int productId, int quantity) {
		ConsumerDto consumerDto = findById(consumerId);
		ProductDto productDto = productService.fetchById(productId);
		ItemDto itemDto = productToItem(productDto, quantity);

//		ArrayList<ItemDto> itemDtos = (ArrayList<ItemDto>) consumerDto.getCart().getItem();
//		for (ItemDto item : itemDtos) { 
//
//			if (item.getName().equals(itemDto.getName())) {
//				item.setQuantity(item.getQuantity() + itemDto.getQuantity());
//				item.setPrice(productDto.getPrice() * item.getQuantity());
//				itemService.saveItems(item);
//				return;
//			}
//		}

		List<ItemDto> itemDtos = consumerDto.getCart().getItem();
		for (ItemDto item : itemDtos) {

			if (item.getName().equals(itemDto.getName())) {
				item.setQuantity(item.getQuantity() + itemDto.getQuantity());
				item.setPrice(productDto.getPrice() * item.getQuantity());
				consumerDto.getCart().setItem(itemDtos);
				cartService.saveCart(consumerDto.getCart());
				return;
			}
		}

		itemDto.setCart(consumerDto.getCart());
		itemService.saveItems(itemDto);
	}

	private ItemDto productToItem(ProductDto productDto, int quantity) {
		ItemDto itemDto = new ItemDto();
		itemDto.setName(productDto.getName());
		itemDto.setPrice(productDto.getPrice() * quantity);
		itemDto.setQuantity(quantity);
		itemDto.setOnOrder(true);
		return itemDto;
	}

	public void addProductToCart(int consumerId, int productId, int quantity) {
		ProductDto dto = productService.fetchById(productId);
		ConsumerDto cd = findById(consumerId);

		String pname = dto.getName();
		double price = dto.getPrice();

		CartDto cartdto = cd.getCart();

		if (cartdto == null) {
			cartdto = new CartDto();
		}

		List<ItemDto> items = cartdto.getItem();

		if (items == null) {
			items = new ArrayList<ItemDto>();
		}

		if (items.isEmpty()) {
			ItemDto item = new ItemDto();
			item.setName(pname);
			item.setPrice(quantity * price);
			item.setQuantity(quantity);
			item.setCart(cartdto);

			itemService.saveItems(item);

			items.add(item);
		} else {
			boolean flag = false;
			for (ItemDto itm : items) {
				if (itm.getName().equals(pname)) {
					itm.setQuantity(itm.getQuantity() + quantity);
					itm.setPrice(itm.getPrice() + (quantity * price));
					itm.setCart(cartdto);
					flag = false;
					break;
				} else {
					flag = true;
				}
			}

			if (flag) {
				ItemDto item = new ItemDto();
				item.setName(pname);
				item.setPrice(quantity * price);
				item.setQuantity(quantity);
				item.setCart(cartdto);

				itemService.saveItems(item);

				items.add(item);
			}
		}

		cartdto.setItem(items);
		cartdto.setConsumerDto(cd);
		cartService.saveCart(cartdto);

		cd.setCart(cartdto);
		consumerDao.createConsumer(cd);

	}

	public List<ItemDto> viewCartItem(int customerId) {
		return findById(customerId).getCart().getItem();
	}

	public void deleteItem(int itemId) {
		itemService.deleteByItem(itemId);
	}

	public void itemSaveForLater(int itemid) {
		ItemDto item = itemService.findById(itemid);
		item.setOnOrder(false);
		itemService.saveItems(item);
	}

	public void itemMoveToCart(int itemid) {
		ItemDto item = itemService.findById(itemid);
		item.setOnOrder(true);
		itemService.saveItems(item);
	}

}
