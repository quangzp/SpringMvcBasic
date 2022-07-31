package com.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvc.constant.SystemConstant;
import com.springmvc.dto.MyUser;
import com.springmvc.entity.RoleEntity;
import com.springmvc.entity.UserEntity;
import com.springmvc.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);

		if (userEntity == null) {
			throw new UsernameNotFoundException("User is not been found");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		// put data to security for maitaining system
		MyUser user = new MyUser(userEntity.getUsername(), userEntity.getPassword(), true, true, true, true, authorities);
		user.setFullName(userEntity.getFullName());
		return user;
	}

}
