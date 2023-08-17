package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.aarun.skipkart.dto.WishListDto;



@Component
public interface WishListRepository extends JpaRepository<WishListDto, Integer> {

}
