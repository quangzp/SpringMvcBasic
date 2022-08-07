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

		CommentDto commentDto = new CommentDto();
		commentDto.setPage(0);
		commentDto.setLimitItems(3);
		commentDto.setTotalItems(commentService.getTotalItemByNewsId(id));
		commentDto.setTotalPages((int) Math.ceil(commentDto.getTotalItems() * 1.0 / commentDto.getLimitItems()));

		Sort sort = new Sort(Direction.DESC, "createdDate");
		Pageable pageable = new PageRequest(commentDto.getPage(), commentDto.getLimitItems(), sort);
		commentDto.setList(commentService.findAllByNewsId(id, pageable));

		ModelAndView mav = new ModelAndView("web/detail");
		mav.addObject("news", newsService.findByID(id));
		mav.addObject("comments", commentDto);
		return mav;
	}
	
	@GetMapping(value = "/news/{cateCode}")
	public ModelAndView showListByCategory(@PathVariable(value = "cateCode", required = true) String code,
										   @RequestParam(value = "page",required = false,defaultValue = "0")Integer page) {
		final int SIZE = 5;
		NewsDto newsDto = new NewsDto();
		newsDto.setPage(page);
		newsDto.setLimitItems(SIZE);
		newsDto.setTotalItems(newsService.getTotalItemsByCategoryCode(code));
		newsDto.setTotalPages((int) Math.ceil(newsDto.getTotalItems() * 1.0 / newsDto.getLimitItems()));
		
		Sort sort = new Sort(Direction.DESC, "createdDate");
		Pageable pageable = new PageRequest(newsDto.getPage(), newsDto.getLimitItems(), sort);
		newsDto.setList(newsService.findAllByCategoryCode(code, pageable));
		newsDto.setCategory(newsDto.getList().get(0).getCategory());
		ModelAndView mav = new ModelAndView("web/category");
		mav.addObject("news",newsDto);
		
		return mav;
	}
}
