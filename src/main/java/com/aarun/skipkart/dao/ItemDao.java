package com.aarun.skipkart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.ItemDto;
import com.aarun.skipkart.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	ItemRepository listRepository;

	public void save(ItemDto itemDto) {
		listRepository.save(itemDto);
	}

	public boolean isIdExists(int itemId) {
		return listRepository.existsById(itemId);
	}

	public List<ItemDto> findAll() {

		return listRepository.findAll();
	}

	public Optional<ItemDto> findById(Integer id) {
		return listRepository.findById(id);
	}
	public Optional<ItemDto> findByName(String name) {
		return listRepository.findByName(name);
	}

	public void deleteById(Integer id) {
		listRepository.deleteById(id);
	}

	public void delete(ItemDto entity) {
		listRepository.delete(entity);
	}

	public void deleteAll() {
		listRepository.deleteAll();
	}
}