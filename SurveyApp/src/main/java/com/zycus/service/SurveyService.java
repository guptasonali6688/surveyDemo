package com.zycus.service;

import java.util.Map;
import java.util.Set;

import com.zycus.entity.Survey;
import com.zycus.entity.User;

public interface SurveyService {

	void newUser(User user);

	User validateUser(Map<String, String> user);
	
	void addSurvey(Survey survey);
	
	Iterable<Survey> viewAllSurvey();
	
	Survey getSurvey(int id);
	
}
