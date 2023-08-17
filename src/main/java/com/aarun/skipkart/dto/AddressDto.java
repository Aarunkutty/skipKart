package com.aarun.skipkart.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Component
@Entity
@Data
public class AddressDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Long phone;
	private String name;
	private String doorNo;
	private String area;
	private int pincode;
	
	@ManyToOne
	private ConsumerDto consumer;

}