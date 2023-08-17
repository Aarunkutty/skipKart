package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.aarun.skipkart.dto.ProductDto;



@Component
public interface ProductRepository extends JpaRepository<ProductDto, Integer> {

}