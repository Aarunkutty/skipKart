package com.aarun.skipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarun.skipkart.dao.MerchantDao;
import com.aarun.skipkart.dto.MerchantDto;

@Service
public class MerchantService {
	@Autowired
	MerchantDao dao;

	public void createMerchant(MerchantDto merchantDto) {
		dao.createMerchant(merchantDto);
	}

	public MerchantDto findById(int id) {
		if (dao.viewMerchantById(id).isPresent())
			return dao.viewMerchantById(id).get();
		return null;
	}

	public MerchantDto merchantLogIn(String merchantemail, long merchantpassword) {
		return dao.merchantLogIn(merchantemail, merchantpassword);

	}

	public void deleteById(Integer merchantid) {
		dao.deleteById(merchantid);
	}

}