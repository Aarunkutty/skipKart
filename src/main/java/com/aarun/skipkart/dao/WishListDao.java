package com.aarun.skipkart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.WishListDto;
import com.aarun.skipkart.repository.WishListRepository;

@Repository
public class WishListDao {
	@Autowired
	WishListRepository listRepository;

	public void save(WishListDto wishListDto) {
		listRepository.save(wishListDto);
	}

	public boolean isIdExists(int wishlistid) {
		return listRepository.existsById(wishlistid);
	}

	public List<WishListDto> findAll() {

		return listRepository.findAll();
	}

	public Optional<WishListDto> findById(Integer id) {
		return listRepository.findById(id);
	}

	public void deleteById(Integer id) {
		listRepository.deleteById(id);
	}

	public void delete(WishListDto entity) {
		listRepository.delete(entity);
	}

	public void deleteAll() {
		listRepository.deleteAll();
	}

}