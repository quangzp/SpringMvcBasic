package com.springmvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springmvc.dto.CategoryDto;
import com.springmvc.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
	ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

	CategoryDto toDto(CategoryEntity entity);

	CategoryEntity toEntity(CategoryDto dto);
}
