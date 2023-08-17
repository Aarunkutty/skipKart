package com.aarun.skipkart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aarun.skipkart.dto.MerchantDto;
import com.aarun.skipkart.repository.MerchantRepository;

@Repository
public class MerchantDao {

	@Autowired
	MerchantRepository merchantRepository;

	public void createMerchant(MerchantDto merchantDto) {
		merchantRepository.save(merchantDto);
	}

	public Optional<MerchantDto> viewMerchantById( int id) {
		return merchantRepository.findById(id);
	}
	

	public boolean isIdExists(int id) {
		return merchantRepository.existsById(id);
	}

	public List<MerchantDto> findAll() {

		return merchantRepository.findAll();
	}

	public void deleteById(Integer id) {
		merchantRepository.deleteById(id);
	}

	public void delete(MerchantDto dto) {
		merchantRepository.delete(dto);
	}

	public void deleteAll() {
		merchantRepository.deleteAll();
	}

	public MerchantDto merchantLogIn(String merchantemail, long merchantpassword) {
		return merchantRepository.validateMerchant(merchantemail, merchantpassword);
	}



}