package com.zycus.service;

import java.util.Map;

import com.zycus.entity.Share;
import com.zycus.entity.Survey;
import com.zycus.entity.User;

public interface SurveyService {

	void newUser(User user);

	User validateUser(Map<String, String> user);

	void addSurvey(Survey survey);

	Iterable<Survey> viewAllSurvey();

	Survey getSurvey(int id);

	Iterable<Survey> getActiveSurvey();

	void deactivateSurvey(Survey survey);

	Iterable<User> getAllUser();

	void newShare(Share share);

}
