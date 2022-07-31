package com.springmvc.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // javax.persistence.Entity
@Table(name = "user") // javax.persistence.Table
public class UserEntity extends BaseEntity {

	@Column
	private String userName;

	@Column
	private String password;

	@Column
	private String fullName;

	@Column
	private Integer status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_role", 
			joinColumns = @JoinColumn(name = "userId"), 
			inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<RoleEntity> roles = new ArrayList<>();

	public String getUsername() {
		return userName;
	}


	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
}
