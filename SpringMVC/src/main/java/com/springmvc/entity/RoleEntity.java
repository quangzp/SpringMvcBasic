package com.springmvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // javax.persistence.Entity
@Table(name = "role")  // javax.persistence.Table
public class RoleEntity extends BaseEntity{
	
	@Column
	private String roleName;
	
	@Column
	private String code;
	
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<>();
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUser(List<UserEntity> users) {
		this.users = users;
	}
	
}
