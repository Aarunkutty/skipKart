package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.aarun.skipkart.dto.AddressDto;


@Component
public interface AddressRepository extends JpaRepository<AddressDto, Long> {

}