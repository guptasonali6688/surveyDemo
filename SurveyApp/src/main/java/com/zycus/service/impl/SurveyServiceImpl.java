package com.zycus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.entity.Admin;
import com.zycus.repository.AdminRepository;
import com.zycus.service.SurveyService;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private AdminRepository adminRepository;
	
	public void newAdmin(Admin admin) {
		adminRepository.save(admin);
	}

}
