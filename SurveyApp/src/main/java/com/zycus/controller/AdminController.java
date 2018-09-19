package com.zycus.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zycus.entity.Survey;
import com.zycus.service.SurveyService;

@Controller
@RequestMapping("/home/*")
public class AdminController {

	@Autowired
	SurveyService service;
	
	@RequestMapping(value="/survey")
	public String newSurvey() {
		
		return "newSurvey";
	}
	
	@RequestMapping(value="/view")
	public String viewSurvey(Model model) {
		Iterable<Survey> surveys  = service.viewAllSurvey();
		model.addAttribute("surveys", surveys);
		return "view-survey";
	}
	
	@PostMapping(value="/SurveyDetails")
	public String surveyDetails(@RequestParam Map<String, String> body , Model model) {
		Survey cur_survey = service.getSurvey(Integer.parseInt(body.get("id")));
		System.out.println(cur_survey.getQuestions().size());
		model.addAttribute("curSurvey", cur_survey);
		return "show-survey";
	}
	
}
