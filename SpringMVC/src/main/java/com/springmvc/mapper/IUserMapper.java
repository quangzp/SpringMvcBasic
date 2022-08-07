package com.springmvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springmvc.dto.UserDto;
import com.springmvc.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface IUserMapper {
	IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

	UserDto toDto(UserEntity entity);

	UserEntity toEntity(UserDto dto);
}
