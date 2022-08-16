package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.CategoryDto;

public interface ICategoryService {
	CategoryDto finAll();
	CategoryDto finOneById(long id);
}
