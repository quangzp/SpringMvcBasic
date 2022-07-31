package com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.NewsEntity;

@Repository
public interface INewsRepository extends JpaRepository<NewsEntity, Long>{
	
}
