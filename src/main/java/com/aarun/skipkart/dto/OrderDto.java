package com.aarun.skipkart.dto;

import java.util.Iterator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private AddressDto address;

	private OrderListDto orderList;

	private Double totalPrice;

	
}
