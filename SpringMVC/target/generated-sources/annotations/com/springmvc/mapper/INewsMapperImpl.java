package com.springmvc.mapper;

import com.springmvc.dto.CategoryDto;
import com.springmvc.dto.NewsDto;
import com.springmvc.entity.CategoryEntity;
import com.springmvc.entity.NewsEntity;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-31T11:36:52+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class INewsMapperImpl implements INewsMapper {

    @Override
    public NewsDto toDto(NewsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( entity.getId() );
        if ( entity.getCreatedDate() != null ) {
            newsDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        if ( entity.getModifiedDate() != null ) {
            newsDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        newsDto.setCreatedBy( entity.getCreatedBy() );
        newsDto.setModifiedBy( entity.getModifiedBy() );
        newsDto.setTitle( entity.getTitle() );
        newsDto.setThumbnail( entity.getThumbnail() );
        newsDto.setShortDescription( entity.getShortDescription() );
        newsDto.setCategory( categoryEntityToCategoryDto( entity.getCategory() ) );
        newsDto.setContent( entity.getContent() );
        newsDto.setSlug( entity.getSlug() );

        return newsDto;
    }

    @Override
    public NewsEntity toEntity(NewsDto dto) {
        if ( dto == null ) {
            return null;
        }

        NewsEntity newsEntity = new NewsEntity();

        newsEntity.setCreatedDate( dto.getCreatedDate() );
        newsEntity.setModifiedDate( dto.getModifiedDate() );
        newsEntity.setCreatedBy( dto.getCreatedBy() );
        newsEntity.setModifiedBy( dto.getModifiedBy() );
        newsEntity.setTitle( dto.getTitle() );
        newsEntity.setThumbnail( dto.getThumbnail() );
        newsEntity.setShortDescription( dto.getShortDescription() );
        newsEntity.setContent( dto.getContent() );
        newsEntity.setCategory( categoryDtoToCategoryEntity( dto.getCategory() ) );
        newsEntity.setSlug( dto.getSlug() );

        return newsEntity;
    }

    protected CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( categoryEntity.getId() );
        if ( categoryEntity.getCreatedDate() != null ) {
            categoryDto.setCreatedDate( new Timestamp( categoryEntity.getCreatedDate().getTime() ) );
        }
        if ( categoryEntity.getModifiedDate() != null ) {
            categoryDto.setModifiedDate( new Timestamp( categoryEntity.getModifiedDate().getTime() ) );
        }
        categoryDto.setCreatedBy( categoryEntity.getCreatedBy() );
        categoryDto.setModifiedBy( categoryEntity.getModifiedBy() );
        categoryDto.setName( categoryEntity.getName() );
        categoryDto.setCode( categoryEntity.getCode() );

        return categoryDto;
    }

    protected CategoryEntity categoryDtoToCategoryEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCreatedDate( categoryDto.getCreatedDate() );
        categoryEntity.setModifiedDate( categoryDto.getModifiedDate() );
        categoryEntity.setCreatedBy( categoryDto.getCreatedBy() );
        categoryEntity.setModifiedBy( categoryDto.getModifiedBy() );
        categoryEntity.setCode( categoryDto.getCode() );
        categoryEntity.setName( categoryDto.getName() );

        return categoryEntity;
    }
}
