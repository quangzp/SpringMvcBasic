package com.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dto.CategoryDto;
import com.springmvc.entity.CategoryEntity;
import com.springmvc.mapper.ICategoryMapper;
import com.springmvc.repository.ICategoryRepository;
import com.springmvc.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private ICategoryMapper mapper;

	@Override
	public CategoryDto finAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		List<CategoryDto> list = new ArrayList<>();
		entities.forEach(e -> list.add(mapper.toDto(e)));

		CategoryDto dto = new CategoryDto();
		dto.setList(list);
		return dto;
	}

	@Override
	public CategoryDto finOneById(long id) {
		CategoryDto dto = mapper.toDto(categoryRepository.findOne(id));
		return dto;
	}

}
