package com.aarun.skipkart.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Component
@Entity 
@Data
public class MerchantDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long password;
	private long phone;
	
	
	//Adding product by merchant (oneToMany)
	@OneToMany(mappedBy = "merchant") 
	private List<ProductDto> products;
	
}