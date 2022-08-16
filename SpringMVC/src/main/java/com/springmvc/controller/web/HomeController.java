package com.springmvc.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.ICategoryService;
import com.springmvc.service.INewsService;

@Controller(value = "homeControllerOfWEB")
@ControllerAdvice
public class HomeController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private INewsService newsService;

	@ModelAttribute
	public void commonAttrs(Model model) {
		model.addAttribute("categories", categoryService.finAll());
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage(Model model) {
		ModelAndView mav = new ModelAndView("web/home");

		mav.addObject("lastestNews", newsService.findAll(new PageRequest(0, 15, Direction.DESC, "createdDate")));

		mav.addObject("lifeStyle",
				newsService.findAllByCategoryCode("life-style", new PageRequest(0, 4, Direction.DESC, "createdDate")));
		
		mav.addObject("travel",
				newsService.findAllByCategoryCode("travel", new PageRequest(0, 4, Direction.DESC, "createdDate")));
		
		mav.addObject("fashion",
				newsService.findAllByCategoryCode("fashion", new PageRequest(0, 4, Direction.DESC, "createdDate")));
		
		mav.addObject("sport",
				newsService.findAllByCategoryCode("sport", new PageRequest(0, 4, Direction.DESC, "createdDate")));
		
		mav.addObject("technology",
				newsService.findAllByCategoryCode("technology", new PageRequest(0, 4, Direction.DESC, "createdDate")));
		
		// default: previous days -30, limit items 5
		mav.addObject("mostComments",newsService.findTopByCommentQuatity(-30, 5));

		return mav;
	}
}