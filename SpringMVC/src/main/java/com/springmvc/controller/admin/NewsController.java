package com.springmvc.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.NewsDto;
import com.springmvc.service.ICategoryService;
import com.springmvc.service.INewsService;
import com.springmvc.utils.NotificationUtil;

@Controller(value = "newsControllerADMIN")
public class NewsController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private INewsService newsService;

	@Autowired
	private NotificationUtil notificationUtil;

	@GetMapping(value = "/admin/news/list")
	public ModelAndView showList(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
			@RequestParam(name = "message", required = false) String message) {

		Sort sort = new Sort(Direction.DESC, "modifiedDate");
		Pageable pageable = new PageRequest(page, size, sort);

		ModelAndView mav = new ModelAndView("admin/news/list");

		if (message != null) {
			Map<String, String> notification = notificationUtil.notice(message);
			mav.addObject("message", notification.get("message"));
			mav.addObject("alert", notification.get("alert"));
		}

		mav.addObject("news", newsService.findAll(pageable));
		return mav;

	}

	@GetMapping(value = { "/admin/news/edit", "/admin/news/add" })
	public ModelAndView edit(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "message", required = false) String message) {
		ModelAndView mav = new ModelAndView("admin/news/edit");
		
		NewsDto newsDto = new NewsDto();
		if (id != null) {
			newsDto = newsService.findByID(id);
		}
		
		if (message != null) {
			Map<String, String> notification = notificationUtil.notice(message);
			mav.addObject("message", notification.get("message"));
			mav.addObject("alert", notification.get("alert"));
		}
		
		mav.addObject("categories", categoryService.finAll());
		mav.addObject("news", newsDto);
		return mav;
	}

}