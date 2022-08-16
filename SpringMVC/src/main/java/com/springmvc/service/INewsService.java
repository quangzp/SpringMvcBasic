package com.springmvc.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.dto.NewsDto;

public interface INewsService {
	NewsDto findAll(Pageable pageable);

	NewsDto findAllByCategoryCode(String code,Pageable pageable);

	NewsDto findTopByCommentQuatity(Integer leftDay, Integer limit);

	Integer getTotalItems();
	Integer getTotalItemsByCategoryCode(String code);

	NewsDto findByID(Long id);

	NewsDto save(NewsDto dto, MultipartFile file);

	void delete(long[] ids);
}
