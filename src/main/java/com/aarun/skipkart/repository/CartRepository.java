package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.aarun.skipkart.dto.CartDto;


@Component
public interface CartRepository extends JpaRepository<CartDto, Integer> {

}