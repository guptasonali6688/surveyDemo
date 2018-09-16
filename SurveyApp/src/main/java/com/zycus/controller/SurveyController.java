package com.zycus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.entity.Admin;
import com.zycus.service.SurveyService;

@RestController
@RequestMapping("/Admin/*")
public class SurveyController {

	@Autowired
	private SurveyService service;
	
	@RequestMapping(value="/addAdmin",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "text/plain")
	public String addAdmin(@RequestBody Admin admin) {
		service.newAdmin(admin);
		return "Registered successfully";
	}
}
