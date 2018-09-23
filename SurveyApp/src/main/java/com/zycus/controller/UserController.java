package com.zycus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zycus.entity.Share;
import com.zycus.entity.User;
import com.zycus.service.SurveyService;

@Controller
@RequestMapping("/surveyApp/home/*")
public class UserController {

	@Autowired
	SurveyService service;
	
	@RequestMapping(value = "/view")
	public String newSurvey(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("user",user);
		//Iterable<Share> shareDetails = service.getSharedSurvey(user.getId());
		return "user-surveylist";
	}
	
}
