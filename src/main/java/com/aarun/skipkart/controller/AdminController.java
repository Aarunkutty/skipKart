package com.aarun.skipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aarun.skipkart.dto.AdminDto;
import com.aarun.skipkart.dto.ConsumerDto;
import com.aarun.skipkart.dto.MerchantDto;
import com.aarun.skipkart.service.AdminService;
import com.aarun.skipkart.service.ConsumerService;
import com.aarun.skipkart.service.MerchantService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	MerchantService merchantService;
	@Autowired
	ConsumerService consumerService;

	@PostMapping("/signup")
	public void createAdmin(@RequestBody AdminDto adminDto) {
		adminService.createAdmin(adminDto);
	}

	@PostMapping("/signin/{adminmail}/{password}")
	public AdminDto adminLogIn(@PathVariable String adminmail, @PathVariable Long password) {
		System.out.println(adminmail + "  "+ password);
		return adminService.adminLogIn(adminmail, password);
	}

	@GetMapping("/merchants/fetch/{merchantid}")
	public MerchantDto viewMerchantById(@PathVariable Integer merchantid) {
		return merchantService.findById(merchantid);
	}

	@GetMapping("/consumers/fetch/{customerid}")
	public ConsumerDto viewConsumer(@PathVariable int customerid) {
		return consumerService.findById(customerid);
	}
	@DeleteMapping("/merchants/delete/{merchantid}")
	public void deleteMerchantById(@PathVariable Integer merchantid) {
		 merchantService.deleteById(merchantid);
	}

	@DeleteMapping("/consumers/delete/{customerid}")
	public void deleteConsumer(@PathVariable int customerid) {
		 consumerService.deleteById(customerid);
	}
}
