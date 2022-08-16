package com.springmvc.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dto.CommentDto;
import com.springmvc.entity.CommentEntity;
import com.springmvc.entity.UserEntity;
import com.springmvc.mapper.ICommentMapper;
import com.springmvc.repository.ICommentRepository;
import com.springmvc.repository.INewsRepository;
import com.springmvc.repository.IUserRepository;
import com.springmvc.service.ICommentService;

@Service
@Transactional
public class CommentService implements ICommentService {

	@Autowired
	private ICommentRepository commentRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private ICommentMapper commentMapper;

	@Autowired
	private INewsRepository newsRepository;

	@Override
	public CommentDto findAllByNewsId(Long newsId, Pageable pageable) {
		List<CommentEntity> entities = commentRepository.findAllByNewsId(newsId, pageable);
		List<CommentDto> dtos = new ArrayList<>();
		for (CommentEntity entity : entities) {
			CommentDto dto = new CommentDto();
			UserEntity userEntity = userRepository.findOneByUserName(entity.getCreatedBy());
			dto.setUserFullName(userEntity.getFullName());
			dto.setContent(entity.getContent());
			dto.setCreatedDate((Timestamp) entity.getCreatedDate());

			dtos.add(dto);
		}

		CommentDto resultComment = new CommentDto();
		resultComment.setPage(pageable.getPageNumber());
		resultComment.setLimitItems(pageable.getPageSize());
		resultComment.setTotalItems(getTotalItemByNewsId(newsId));
		resultComment
				.setTotalPages((int) Math.ceil(resultComment.getTotalItems() * 1.0 / resultComment.getLimitItems()));
		resultComment.setList(dtos);
		return resultComment;
	}

	@Override
	public Integer getTotalItemByNewsId(Long newsId) {
		return commentRepository.countByNewsId(newsId);
	}

	@Override
	public CommentDto save(CommentDto commentDto) {
		CommentEntity commentEntity = commentMapper.toEntity(commentDto);
		commentEntity.setNews(newsRepository.findOne(commentDto.getNewsId()));

		commentDto = commentMapper.toDto(commentRepository.save(commentEntity));
		UserEntity userEntity = userRepository.findOneByUserName(commentDto.getCreatedBy());
		commentDto.setUserFullName(userEntity.getFullName());
		return commentDto;
	}

}
