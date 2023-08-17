package com.aarun.skipkart.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Component
@Entity 
@Data
public class ConsumerDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long password;
	private long phone;
	
	@OneToOne
	private CartDto cart ;
	
	@OneToMany(mappedBy = "consumer")
	private List<AddressDto> address;
	
	@OneToMany
	private List<WishListDto> wishLists;
	
	
}
