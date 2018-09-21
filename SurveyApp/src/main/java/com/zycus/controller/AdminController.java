package com.zycus.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zycus.entity.Survey;
import com.zycus.entity.User;
import com.zycus.service.SurveyService;

@Controller
@RequestMapping("/home/*")
public class AdminController {

	@Autowired
	SurveyService service;

	@RequestMapping(value = "/survey")
	public String newSurvey() {

		return "newSurvey";
	}

	@RequestMapping(value = "/view")
	public String viewSurvey(Model model) {
		Iterable<Survey> surveys = service.viewAllSurvey();
		model.addAttribute("surveys", surveys);
		return "view-survey";
	}

	@PostMapping(value = "/SurveyDetails")
	public String surveyDetails(@RequestParam Map<String, String> body, Model model) {
		Survey cur_survey = service.getSurvey(Integer.parseInt(body.get("id")));
		System.out.println(cur_survey.getQuestions().size());
		model.addAttribute("curSurvey", cur_survey);
		return "show-survey";
	}

	@RequestMapping(value = "/deactivateSurvey")
	public String deactivateSurvey(Model model) {
		Iterable<Survey> surveys = service.getActiveSurvey();
		model.addAttribute("surveys", surveys);
		return "deactivate-survey";
	}

	@RequestMapping(value = "/shareSurvey")
	public String shareSurvey(Model model) {
		Iterable<Survey> surveys = service.viewAllSurvey();
		model.addAttribute("surveys", surveys);
		return "share-survey";
	}

	@PostMapping(value = "/share")
	public String shareToUser(@RequestParam Map<String, String> body, Model model, HttpServletRequest request) {
		Iterable<User> users = service.getAllUser();
		System.out.println(users);
		Survey cur_survey = service.getSurvey(Integer.parseInt(body.get("id")));
		System.out.println(cur_survey.getQuestions().size());
		model.addAttribute("curSurvey", cur_survey);
		model.addAttribute("users", users);
		model.addAttribute("admin", request.getSession().getAttribute("user"));
		return "share-view";
	}

}
