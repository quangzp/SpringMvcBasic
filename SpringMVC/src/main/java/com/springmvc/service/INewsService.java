package com.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.dto.NewsDto;


public interface INewsService {
	List<NewsDto> findAll(Pageable pageable);
	Integer getTotalItems();
	NewsDto findByID(Long id);
	NewsDto save(NewsDto dto, MultipartFile file);
	void delete(long[] ids);
}
