package com.springmvc.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.springmvc.dto.MyUser;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return myUser;
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> result = new ArrayList<String>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities());
		for (GrantedAuthority authority : authorities) {
			result.add(authority.getAuthority());
		}
		return result;
	}
}
