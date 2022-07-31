package com.springmvc.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.INewsService;

@Controller(value = "newsController-Web")
public class NewsController {
	
	@Autowired
	private INewsService newsService;
	
	@RequestMapping(value = "/news/{newsId}/*", method = RequestMethod.GET)
	   public ModelAndView detail(@PathVariable(value = "newsId",required = true) long id) {
		
	      ModelAndView mav = new ModelAndView("web/detail");
	      mav.addObject("news", newsService.findByID(id)); 
	      return mav;
	   }
}
