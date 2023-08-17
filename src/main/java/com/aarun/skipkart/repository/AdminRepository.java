package com.aarun.skipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.aarun.skipkart.dto.AdminDto;


@Component
public interface AdminRepository extends JpaRepository<AdminDto, Integer> {



	@Query("select data from AdminDto data where email=:email and password=:password")
	AdminDto validateAdmin(String email, Long password);
}
