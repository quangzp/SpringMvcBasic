package com.springmvc.service;

import org.springframework.data.domain.Pageable;

import com.springmvc.dto.CommentDto;

public interface ICommentService {
	CommentDto findAllByNewsId(Long newsId, Pageable pageable);
	Integer getTotalItemByNewsId(Long newsId);
	CommentDto save(CommentDto commentDto);
}
