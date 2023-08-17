package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.MerchantDto;


@Repository
public interface MerchantRepository extends JpaRepository<MerchantDto, Integer> {


	@Query("select data from MerchantDto data where email=:email and password=:password")
	MerchantDto validateMerchant(String email, long password);


}
