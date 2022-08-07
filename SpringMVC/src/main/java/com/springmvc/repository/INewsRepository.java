package com.springmvc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.NewsEntity;

@Repository
public interface INewsRepository extends JpaRepository<NewsEntity, Long>{
	List<NewsEntity> findAllByCategoryCode(String code,Pageable pageable);
	
	
	@Query(value = "SELECT news.* FROM news"
			+ "	left join comment"
			+ "	on news.id = comment.news_id"
			+ "	where DATE(news.createdDate) between DATE_ADD(CURDATE(),INTERVAL (:left_day) DAY) and CURDATE()"
			+ "	group by news.id"
			+ "	order by count(news_id) desc limit :limit", nativeQuery = true)
	List<NewsEntity> getTopNewsByQuatityComment(@Param(value = "left_day") Integer leftDay,
												@Param(value = "limit") Integer limit);
	
	Integer countByCategoryCode(String code);
}
