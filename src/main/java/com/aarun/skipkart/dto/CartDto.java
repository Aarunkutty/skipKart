package com.aarun.skipkart.dto;

import java.util.ArrayList;
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
public class CartDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Items(products)(oneToMany)
	@OneToOne
	private ConsumerDto consumerDto;
	
	@OneToMany(mappedBy = "cart")
	private List<ItemDto> item = new ArrayList<>();

}