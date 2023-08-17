package com.aarun.skipkart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.AdminDto;
import com.aarun.skipkart.repository.AdminRepository;

@Repository 

public class AdminDao {
	
	@Autowired
	AdminRepository adminRepository;

	public void createAdmin(AdminDto adminDto) {
		adminRepository.save(adminDto);
	}

	public boolean isIdExists(int adminId) {
		return adminRepository.existsById(adminId);
	}

	public List<AdminDto> findAll() {

		return adminRepository.findAll();
	}

	public Optional<AdminDto> findById(Integer id) {
		return adminRepository.findById(id);
	}

	public void deleteById(Integer id) {
		adminRepository.deleteById(id);
	}

	public void delete(AdminDto entity) {
		adminRepository.delete(entity);
	}

	public void deleteAll() {
		adminRepository.deleteAll();
	}

	public AdminDto adminLogIn(String adminmail, long password) {
		return adminRepository.validateAdmin(adminmail, password);
	}

	
}
