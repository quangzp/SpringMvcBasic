package com.springmvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springmvc.dto.NewsDto;
import com.springmvc.entity.NewsEntity;

@Mapper(componentModel = "spring")
public interface INewsMapper {
	INewsMapper INSTANCE = Mappers.getMapper(INewsMapper.class);
	
	NewsDto toDto(NewsEntity entity);
	
	NewsEntity toEntity(NewsDto dto);
	
	default NewsEntity toEntity(NewsDto dto, NewsEntity entity) {
		entity.setTitle( dto.getTitle() );
		entity.setThumbnail( dto.getThumbnail() );
		entity.setShortDescription( dto.getShortDescription() );
		entity.setContent( dto.getContent() );
		return entity;
	}
}
