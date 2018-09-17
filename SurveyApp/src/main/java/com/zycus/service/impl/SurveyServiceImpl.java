package com.zycus.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.entity.User;
import com.zycus.repository.UserRepository;
import com.zycus.service.SurveyService;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private UserRepository userRepository;
	
	public void newUser(User user) {
		userRepository.save(user);
	}

	public User validateUser(Map<String, String> user) {
		return userRepository.getUserFromIdPass(user.get("username"), user.get("password"));
	}
}
