package com.springmvc.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.constant.SystemConstant;
import com.springmvc.dto.UserDto;
import com.springmvc.entity.RoleEntity;
import com.springmvc.entity.UserEntity;
import com.springmvc.exception.UserAlreadyExistException;
import com.springmvc.mapper.IUserMapper;
import com.springmvc.repository.IRoleRepository;
import com.springmvc.repository.IUserRepository;
import com.springmvc.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUserMapper mapper;

	@Override
	public void register(UserDto userDto) throws UserAlreadyExistException {
		

		if (checkIfUserExist(userDto.getUserName())) {
			throw new UserAlreadyExistException("User already exists for this email");
		}
		UserEntity userEntity = mapper.toEntity(userDto);
		userEntity.setStatus(SystemConstant.ACTIVE_STATUS);
		
		RoleEntity roleEntity = roleRepository.findOneByCode(SystemConstant.USER);
		userEntity.setRoles(Arrays.asList(roleEntity));
		
		encodePassword(userEntity, userDto);

		userRepository.save(userEntity);
	}

	private boolean checkIfUserExist(String userName) {
		return userRepository.findOneByUserName(userName) != null ? true : false;
	}

	private void encodePassword(UserEntity userEntity, UserDto userDto) {
		userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
	}

}
