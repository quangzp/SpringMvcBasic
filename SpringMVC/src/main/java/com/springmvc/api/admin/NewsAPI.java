package com.springmvc.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.dto.NewsDto;
import com.springmvc.service.INewsService;

@RestController(value = "newsAPI-admin")
public class NewsAPI {

	@Autowired
	private INewsService newsService;
	
	
	@PostMapping(value = "/api/admin/news", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public NewsDto createNews(@RequestPart("news") NewsDto newsDto,@RequestPart(name = "thumbnail",required = false) MultipartFile photoFile) {
		return newsService.save(newsDto,photoFile);
	}

	@PutMapping(value = "/api/admin/news", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public NewsDto updateNews(@RequestPart("news") NewsDto newsDto,@RequestPart(value = "thumbnail",required = false) MultipartFile photoFile) {
		return newsService.save(newsDto,photoFile);
	}

	@DeleteMapping("/api/admin/news")
	public void deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
	}
}
