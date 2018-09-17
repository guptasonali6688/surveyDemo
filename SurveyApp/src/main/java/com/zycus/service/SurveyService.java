package com.zycus.service;

import java.util.Map;

import com.zycus.entity.User;

public interface SurveyService {

	void newUser(User user);

	User validateUser(Map<String, String> user);
	
}
