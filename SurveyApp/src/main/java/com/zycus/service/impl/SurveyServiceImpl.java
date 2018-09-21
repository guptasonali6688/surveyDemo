package com.zycus.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.entity.Question;
import com.zycus.entity.Share;
import com.zycus.entity.Survey;
import com.zycus.entity.User;
import com.zycus.repository.ShareSurveyRepository;
import com.zycus.repository.SurveyRepository;
import com.zycus.repository.UserRepository;
import com.zycus.service.SurveyService;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private ShareSurveyRepository shareSurveyRepository;

	public void newUser(User user) {
		userRepository.save(user);
	}

	public User validateUser(Map<String, String> user) {
		return userRepository.getUserFromIdPass(user.get("username"), user.get("password"));
	}

	public void addSurvey(Survey survey) {
		Set<Question> questions = survey.getQuestions();
		for (Question q : questions) {
			q.setSurvey(survey);
		}
		surveyRepository.save(survey);
	}

	public Iterable<Survey> viewAllSurvey() {
		return surveyRepository.findAll();

	}

	public Survey getSurvey(int id) {
		return surveyRepository.findById(id).get();
	}

	public Iterable<Survey> getActiveSurvey() {
		return surveyRepository.getActiveSurvey();
	}

	public void deactivateSurvey(Survey survey) {
		surveyRepository.deactivateSurvey(survey.getId());
	}

	public Iterable<User> getAllUser() {
		return userRepository.findByRole();
	}

	public void newShare(Share share) {
		shareSurveyRepository.save(share);
	}

}
