package com.springmvc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.CommentEntity;

@Repository
public interface ICommentRepository extends JpaRepository<CommentEntity, Long> {
	List<CommentEntity> findAllByNewsId(Long newsId, Pageable pageable);
	Integer countByNewsId(Long newsId);
}
