package com.aarun.skipkart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.ConsumerDto;
import com.aarun.skipkart.repository.ConsumerRepository;

@Repository
public class ConsumerDao {

	@Autowired
	ConsumerRepository consumerRepository;

	public void createConsumer(ConsumerDto consumerDTO) {
		consumerRepository.save(consumerDTO);
	}

	public Optional<ConsumerDto> findById(int customerid) {
		
		return consumerRepository.findById(customerid);
	}

	public boolean isIdExists(int id) {
		return consumerRepository.existsById(id);
	}

	public List<ConsumerDto> findAll() {

		return consumerRepository.findAll();
	}

	public void deleteById(Integer id) {
		consumerRepository.deleteById(id);
	}

	public void delete(ConsumerDto dto) {
		consumerRepository.delete(dto);
	}

	public void deleteAll() {
		consumerRepository.deleteAll();
	}

	public ConsumerDto consumerLogIn(String consumeremail, long consumerpassword) {
		return consumerRepository.validateCustomer(consumeremail, consumerpassword);
	}
}
