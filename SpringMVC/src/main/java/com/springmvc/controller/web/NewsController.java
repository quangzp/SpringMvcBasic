package com.springmvc.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.CommentDto;
import com.springmvc.dto.NewsDto;
import com.springmvc.service.ICommentService;
import com.springmvc.service.INewsService;

@Controller(value = "newsController-Web")
public class NewsController {

	@Autowired
	private INewsService newsService;

	@Autowired
	private ICommentService commentService;

	@GetMapping(value = "/news/{newsId}/{slug}")
	public ModelAndView showDetail(@PathVariable(value = "newsId", required = true) Long id) {

		final int page = 0;
		final int size = 3;
		Sort sort = new Sort(Direction.DESC, "createdDate");
		Pageable pageable = new PageRequest(page, size, sort);

		ModelAndView mav = new ModelAndView("web/detail");
		mav.addObject("news", newsService.findByID(id));
		mav.addObject("comments", commentService.findAllByNewsId(id, pageable));
		
		return mav;
	}
	
	@GetMapping(value = "/news/{cateCode}")
	public ModelAndView showListByCategory(@PathVariable(value = "cateCode", required = true) String code,
										   @RequestParam(value = "page",required = false,defaultValue = "0")Integer page) {
		final int SIZE = 5;//default element of a page
		Sort sort = new Sort(Direction.DESC, "createdDate");
		Pageable pageable = new PageRequest(page, SIZE, sort);
		
		ModelAndView mav = new ModelAndView("web/category");
		mav.addObject("news",newsService.findAllByCategoryCode(code, pageable));
		
		return mav;
	}
}
