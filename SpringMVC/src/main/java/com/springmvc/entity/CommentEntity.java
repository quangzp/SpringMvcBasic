package com.springmvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // javax.persistence.Entity
@Table(name = "comment") // javax.persistence.Table
public class CommentEntity extends BaseEntity {

	@Column
	private String content;
	
	
}
