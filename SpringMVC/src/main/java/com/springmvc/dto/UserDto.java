package com.springmvc.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.springmvc.validator.PasswordMatches;

@PasswordMatches(field = "confirmPassword")
public class UserDto extends AbstractDto<UserDto> {
	/**
	 * 
	 */
	@NotNull
	@NotEmpty(message = "First name can not be empty")
    private String firstName;

	@NotNull
    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

	@NotNull
    @NotEmpty(message = "Email can not be empty")
    private String userName;

	@NotNull
    @NotEmpty(message = "Password can not be empty")
    private String password;
    private String confirmPassword;
    
    private List<String> roleCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<String> getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(List<String> roleCode) {
		this.roleCode = roleCode;
	}
    
    
}
