package com.aarun.skipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aarun.skipkart.dto.MerchantDto;
import com.aarun.skipkart.dto.ProductDto;
import com.aarun.skipkart.service.MerchantService;
import com.aarun.skipkart.service.ProductService;

@RestController
@RequestMapping("/merchants")
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	@Autowired
	ProductService productService;

	@PostMapping("/signup")
	public void createMerchant(@RequestBody MerchantDto merchantDto) {
		merchantService.createMerchant(merchantDto);
	}

	@PostMapping("/signin/{merchantemail}/{merchantpassword}")
	public MerchantDto merchantLogIn(String merchantemail, long merchantpassword) {
		return merchantService.merchantLogIn(merchantemail, merchantpassword);
	}


	@GetMapping("/updatemerchant/{merchantid}")
	public MerchantDto updateMerchant( @PathVariable int merchantid) {
		return merchantService.findById(merchantid);
	}

	
	@PostMapping("/addproduct/{merchantid}")
	public void saveProduct(@RequestBody ProductDto productDto, @PathVariable int merchantid) {
		MerchantDto dto2 =  merchantService.findById(merchantid);
		productDto.setMerchant(dto2);
		productService.saveProduct(productDto);
	}

	@GetMapping("/viewproducts")
	public void viewProducts() {
		productService.viewProducts();
	}

	@GetMapping("/viewproductbyid/{id}")
	public void viewProductById(@PathVariable int id) {
		productService.viewProductById(id);
	}

	@DeleteMapping("/removeproducts")
	public void deleteProducts() {
		productService.deleteProducts();
	}

	@DeleteMapping("/removeproductbyid")
	public void deleteProductById(@RequestParam int id) {
		if (productService.existProductById(id)) {
			productService.deleteProductById(id);
		}

	}
	
	@GetMapping("/editproduct/{productid}")
	public void editProduct(@PathVariable Integer productid) {
		productService.fetchById(productid);
	}
	
	@PutMapping("/updateproduct")
	public void updateProduct(@RequestBody ProductDto dto) {
		productService.updateProduct(dto);
	}
}
