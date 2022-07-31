package com.springmvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // javax.persistence.Entity
@Table(name = "category") // javax.persistence.Table
public class CategoryEntity extends BaseEntity {

	@Column
	private String code;

	@Column
	private String name;

	@OneToMany(mappedBy = "category")
	private List<NewsEntity> news = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
