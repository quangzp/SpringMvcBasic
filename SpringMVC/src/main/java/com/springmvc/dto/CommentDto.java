package com.springmvc.dto;

import javax.validation.constraints.NotBlank;

public class CommentDto extends AbstractDto<CommentDto> {
	@NotBlank
	private String content;
	private Long newsId;
	private String userFullName;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	

}
