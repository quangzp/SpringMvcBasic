package com.springmvc.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	

	@RequestMapping(value = "/admin/news/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
								 @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
								 @RequestParam(name = "message", required = false) String message) {
		Sort sortByDate = new Sort(Direction.DESC,"modifiedDate");
		Pageable pageable = new PageRequest(page, size,sortByDate);
		NewsDto newsDto = new NewsDto();
		newsDto.setList(newsService.findAll(pageable));
		newsDto.setPage(page);
		newsDto.setLimitItems(size);
		newsDto.setTotalItems(newsService.getTotalItems());
		newsDto.setTotalPages((int) Math.ceil(newsDto.getTotalItems() * 1.0 / newsDto.getLimitItems()));
		ModelAndView mav = new ModelAndView("admin/news/list");
		if(message != null) {
			Map<String, String> notification =  notificationUtil.notice(message);
			mav.addObject("message", notification.get("message"));
			mav.addObject("alert", notification.get("alert"));
		}
		mav.addObject("news", newsDto);
		return mav;
		
	}

	@RequestMapping(value = {"/admin/news/edit","/admin/news/add"}, method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(name = "id", required = false) Long id,
							 @RequestParam(name = "message", required = false) String message) {
		NewsDto newsDto = new NewsDto();
		if(id != null) {
			newsDto = newsService.findByID(id);
		}
		ModelAndView mav = new ModelAndView("admin/news/edit");
		if(message != null) {
			Map<String, String> notification =  notificationUtil.notice(message);
			mav.addObject("message", notification.get("message"));
			mav.addObject("alert", notification.get("alert"));
		}
		mav.addObject("categories", categoryService.finAll());
		mav.addObject("news", newsDto);
		return mav;
	}

}