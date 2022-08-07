package com.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // javax.persistence.Entity
@Table(name = "comment") // javax.persistence.Table
public class CommentEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3369974810906903649L;

	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "news_id")
	@JsonIgnore
	private NewsEntity news;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NewsEntity getNews() {
		return news;
	}

	public void setNews(NewsEntity news) {
		this.news = news;
	}
	
	
}
