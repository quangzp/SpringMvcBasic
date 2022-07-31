package com.springmvc.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.CategoryDto;
import com.springmvc.repository.ICategoryRepository;
import com.springmvc.service.ICategoryService;
import com.springmvc.service.INewsService;

@Controller(value = "homeControllerOfWEB")
public class HomeController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private INewsService newsService;
  
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage() {
	  
      ModelAndView mav = new ModelAndView("web/home");
      mav.addObject("categories", categoryService.finAll());
      mav.addObject("news",newsService.findAll(null));
      return mav;
   }
   
   @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login/login");
		return mav;
	}
  
   @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(req, resp, authentication);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
   
   @RequestMapping(value = "/login/401", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView mav = new ModelAndView("401");
		return mav;
	}
}