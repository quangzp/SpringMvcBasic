package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "LoggingController")
public class LoggingController {
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView loginPage() {
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
	   
	   @RequestMapping(value = "/login/401", method = RequestMethod.GET)
		public ModelAndView accessDenied() {
			ModelAndView mav = new ModelAndView("401");
			return mav;
		}
}
