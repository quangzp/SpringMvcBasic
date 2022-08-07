package com.springmvc.mapper;

import com.springmvc.dto.CommentDto;
import com.springmvc.entity.CommentEntity;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T14:04:13+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ICommentMapperImpl implements ICommentMapper {

    @Override
    public CommentDto toDto(CommentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId( entity.getId() );
        if ( entity.getCreatedDate() != null ) {
            commentDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        if ( entity.getModifiedDate() != null ) {
            commentDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        commentDto.setCreatedBy( entity.getCreatedBy() );
        commentDto.setModifiedBy( entity.getModifiedBy() );
        commentDto.setContent( entity.getContent() );

        return commentDto;
    }

    @Override
    public CommentEntity toEntity(CommentDto dto) {
        if ( dto == null ) {
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setCreatedDate( dto.getCreatedDate() );
        commentEntity.setModifiedDate( dto.getModifiedDate() );
        commentEntity.setCreatedBy( dto.getCreatedBy() );
        commentEntity.setModifiedBy( dto.getModifiedBy() );
        commentEntity.setContent( dto.getContent() );

        return commentEntity;
    }
}
