package com.aarun.skipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarun.skipkart.dao.AdminDao;
import com.aarun.skipkart.dto.AdminDto;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	public void createAdmin(AdminDto adminDto) {
		adminDao.createAdmin(adminDto);
	}

	public AdminDto adminLogIn(String adminmail, Long password) {
		return adminDao.adminLogIn(adminmail, password);
	}

}
