package com.aarun.skipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarun.skipkart.dao.ItemDao;
import com.aarun.skipkart.dto.ItemDto;

@Service
public class ItemService {

	@Autowired
	ItemDao itemDao;

	public void saveItems(ItemDto itemDto) {
		itemDao.save(itemDto);
	}

	public void deleteByItem(int itemId) {
		itemDao.findById(itemId);
	}

	public ItemDto findById(int itemid) {
		if(itemDao.findById(itemid).isPresent())
			return itemDao.findById(itemid).get();
	return null;
	}


	
}
