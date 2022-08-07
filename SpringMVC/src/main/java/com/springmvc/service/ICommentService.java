package com.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.springmvc.dto.CommentDto;

public interface ICommentService {
	List<CommentDto> findAllByNewsId(Long newsId, Pageable pageable);
	Integer getTotalItemByNewsId(Long newsId);
	CommentDto save(CommentDto commentDto);
}
