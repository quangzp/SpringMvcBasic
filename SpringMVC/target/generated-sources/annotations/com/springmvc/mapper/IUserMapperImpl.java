package com.springmvc.mapper;

import com.springmvc.dto.UserDto;
import com.springmvc.entity.UserEntity;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T14:04:13+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserDto toDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        if ( entity.getCreatedDate() != null ) {
            userDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        if ( entity.getModifiedDate() != null ) {
            userDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        userDto.setCreatedBy( entity.getCreatedBy() );
        userDto.setModifiedBy( entity.getModifiedBy() );
        userDto.setFirstName( entity.getFirstName() );
        userDto.setLastName( entity.getLastName() );
        userDto.setUserName( entity.getUserName() );
        userDto.setPassword( entity.getPassword() );

        return userDto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setCreatedDate( dto.getCreatedDate() );
        userEntity.setModifiedDate( dto.getModifiedDate() );
        userEntity.setCreatedBy( dto.getCreatedBy() );
        userEntity.setModifiedBy( dto.getModifiedBy() );
        userEntity.setUserName( dto.getUserName() );
        userEntity.setPassword( dto.getPassword() );
        userEntity.setFirstName( dto.getFirstName() );
        userEntity.setLastName( dto.getLastName() );

        return userEntity;
    }
}
