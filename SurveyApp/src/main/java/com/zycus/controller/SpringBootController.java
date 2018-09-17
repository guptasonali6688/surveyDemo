package com.zycus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zycus.entity.User;

@Controller
@RequestMapping("/*")
public class SpringBootController {
	
	 @RequestMapping(value="/",method = RequestMethod.GET, produces = "text/plain")
	    public String index() {
	        return "index";
	    }
	 
	 @RequestMapping(value="/register", method = RequestMethod.GET, produces = "text/plain")
	    public String newUser() {
	        return "newUser";
	    }
	 
	 @RequestMapping(value="/login", method = RequestMethod.GET, produces = "text/plain")
	    public String login() {
	        return "login-view";
	    }
	 
	 @RequestMapping(value="/home", method = RequestMethod.GET, produces = "text/plain")
	    public String home() {
	        return "home.html";
	    }
	 
	 @RequestMapping("/survey/home")
		public String goHome(HttpServletRequest request)
		{
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			if (user != null)
			{
				if (user.getRole().equalsIgnoreCase("ADMIN"))
				{
					return "admin-home";
				}
				else
				{
					return "user-home";
				}
			}
			
			return null;
		}
}
