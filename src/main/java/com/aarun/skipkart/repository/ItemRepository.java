package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.CartDto;
import com.aarun.skipkart.dto.ItemDto;
import java.util.List;
import java.util.Optional;



@Repository
public interface ItemRepository extends JpaRepository<ItemDto, Integer> {

	Optional<ItemDto> findByName(String name);
	
}