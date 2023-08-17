package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.aarun.skipkart.dto.ConsumerDto;

@Component
public interface ConsumerRepository extends JpaRepository<ConsumerDto, Integer> {

	@Query("select data from ConsumerDto data where email=:email and password=:password")
	ConsumerDto validateCustomer(String email, long password);

}
