package com.zycus.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.entity.Question;
import com.zycus.entity.Survey;
import com.zycus.entity.User;
import com.zycus.service.SurveyService;

@RestController
@RequestMapping("/survey/*")
public class SurveyController {

	@Autowired
	private SurveyService service;
	
	@RequestMapping(value="/addUser",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "text/plain")
	public String addUser(@RequestBody User user) {
		service.newUser(user);
		return "Registered successfully";
	}
	
	@RequestMapping(value="/userLogin",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces="application/json")
	public boolean userLogin(@RequestBody Map<String, String> userMap, HttpServletRequest request) {

		User user = service.validateUser(userMap);
		if (user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return true;
		}
		return false;
	}

	@RequestMapping(value="/addSurvey")
	public String addSurvey(@RequestBody Survey survey, HttpServletRequest request) {
		System.out.println(survey);
		
		User user = (User) request.getSession().getAttribute("user");
		survey.setUser(user);
		
		service.addSurvey(survey);
		return "Survey successfully created..";
	}
	
}
