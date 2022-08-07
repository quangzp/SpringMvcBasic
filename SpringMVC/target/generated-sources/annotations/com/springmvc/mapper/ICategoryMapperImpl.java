package com.springmvc.mapper;

import com.springmvc.dto.CategoryDto;
import com.springmvc.entity.CategoryEntity;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T14:04:13+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ICategoryMapperImpl implements ICategoryMapper {

    @Override
    public CategoryDto toDto(CategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( entity.getId() );
        if ( entity.getCreatedDate() != null ) {
            categoryDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        if ( entity.getModifiedDate() != null ) {
            categoryDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        categoryDto.setCreatedBy( entity.getCreatedBy() );
        categoryDto.setModifiedBy( entity.getModifiedBy() );
        categoryDto.setName( entity.getName() );
        categoryDto.setCode( entity.getCode() );

        return categoryDto;
    }

    @Override
    public CategoryEntity toEntity(CategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCreatedDate( dto.getCreatedDate() );
        categoryEntity.setModifiedDate( dto.getModifiedDate() );
        categoryEntity.setCreatedBy( dto.getCreatedBy() );
        categoryEntity.setModifiedBy( dto.getModifiedBy() );
        categoryEntity.setCode( dto.getCode() );
        categoryEntity.setName( dto.getName() );

        return categoryEntity;
    }
}
