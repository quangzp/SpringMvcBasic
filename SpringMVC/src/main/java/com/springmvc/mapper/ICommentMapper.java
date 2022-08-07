package com.springmvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springmvc.dto.CommentDto;
import com.springmvc.entity.CommentEntity;

@Mapper(componentModel = "spring")
public interface ICommentMapper {
	ICommentMapper INSTANCE = Mappers.getMapper(ICommentMapper.class);

	CommentDto toDto(CommentEntity entity);

	CommentEntity toEntity(CommentDto dto);
}
