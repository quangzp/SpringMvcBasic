package com.springmvc.api.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.dto.NewsDto;
import com.springmvc.service.INewsService;

@RestController(value = "newsAPI-admin")
public class NewsApi {

	@Autowired
	private INewsService newsService;

	@PostMapping(value = "/api/admin/news",produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public NewsDto saveOrUpdate(@RequestPart("news") @Valid NewsDto newsDto,
			@RequestPart(name = "photoFile", required = false) MultipartFile photoFile,
			BindingResult result) {
		if(!result.hasErrors() || photoFile.isEmpty()) {
			return newsService.save(newsDto, photoFile);			
		}
		return newsDto;

	}

	@DeleteMapping("/api/admin/news")
	public void deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
	}
}
