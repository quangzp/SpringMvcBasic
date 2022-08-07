package com.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.UserDto;
import com.springmvc.exception.UserAlreadyExistException;
import com.springmvc.service.IUserService;

@Controller(value = "RegistrationController")
public class RegistrationController {

	@Autowired
	private IUserService userService;

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserDto());
		return mav;
	}

	@PostMapping(value="/register")
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
											Errors errors) {
		ModelAndView mav = new ModelAndView();
		if (!errors.hasErrors()) {
			try {
				userService.register(userDto);
				mav.setViewName("login");
				return mav;
			} catch (UserAlreadyExistException e) {
				errors.rejectValue("userName", "user", "An account already exists for this user name.");
			}
		}
		mav.setViewName("register");
		mav.addObject("user", userDto);
		return mav;
	}

}
