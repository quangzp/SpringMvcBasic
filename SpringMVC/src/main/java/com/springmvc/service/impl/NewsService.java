package com.springmvc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.springmvc.dto.NewsDto;
import com.springmvc.entity.CategoryEntity;
import com.springmvc.entity.NewsEntity;
import com.springmvc.mapper.INewsMapper;
import com.springmvc.repository.ICategoryRepository;
import com.springmvc.repository.ICommentRepository;
import com.springmvc.repository.INewsRepository;
import com.springmvc.service.INewsService;

@Service
@Transactional
public class NewsService implements INewsService {

	@Autowired
	private INewsRepository newsRepository;

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private ICommentRepository commentRepository;

	@Autowired
	private INewsMapper mapper;

	@Autowired
	private Cloudinary cloudinary;

	@Override
	public List<NewsDto> findAll(Pageable pageable) {
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		List<NewsDto> dtos = new ArrayList<>();
		for (NewsEntity entity : entities) {
			NewsDto dto = mapper.toDto(entity);
			dto.setCategoryCode(dto.getCategory().getCode());
			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public Integer getTotalItems() {
		return (int) newsRepository.count();
	}

	@Override
	public NewsDto findByID(Long id) {
		NewsEntity entity = newsRepository.findOne(id);
		NewsDto dto = mapper.toDto(entity);
		dto.setCategoryCode(dto.getCategory().getCode());
		return dto;
	}

	@Override
	public NewsDto save(NewsDto dto, MultipartFile file) {
		NewsEntity newsEntity = new NewsEntity();

		if (file != null) {
			try {
				Map resp = cloudinary.uploader().upload(file.getBytes(),
						ObjectUtils.asMap("public_id", dto.getSlug(), "resource_type", "auto"));
				dto.setThumbnail((String) resp.get("secure_url"));

			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());

			}
		}

		Long id = dto.getId();

		if (id != null) { // update
			newsEntity = newsRepository.findOne(id);
			newsEntity = mapper.toEntity(dto, newsEntity);

		} else {
			newsEntity = mapper.toEntity(dto);
		}

		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
		newsEntity.setCategory(categoryEntity);

		return mapper.toDto(newsRepository.save(newsEntity));
	}

	@Override
	public void delete(long[] ids) {
		List<String> publicIds = new ArrayList<>();
		for (long id : ids) {
			publicIds.add(newsRepository.findOne(id).getSlug());
			newsRepository.delete(id);
		}
		try {
			cloudinary.api().deleteResources(publicIds, ObjectUtils.emptyMap());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<NewsDto> findAllByCategoryCode(String code, Pageable pageable) {
		List<NewsEntity> entities = newsRepository.findAllByCategoryCode(code, pageable);
		List<NewsDto> dtos = new ArrayList<>();

		for (NewsEntity entity : entities) {
			NewsDto dto = mapper.toDto(entity);
			dto.setCategoryCode(dto.getCategory().getCode());
			setTotalComment(dto);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public List<NewsDto> findTopByCommentQuatity(Integer leftDay, Integer limit) {
		List<NewsEntity> entities = newsRepository.getTopNewsByQuatityComment(leftDay,limit);
		List<NewsDto> dtos = new ArrayList<>();

		entities.forEach(e -> {
			dtos.add(mapper.toDto(e));
		});
		return dtos;
	}

	@Override
	public Integer getTotalItemsByCategoryCode(String code) {
		
		return newsRepository.countByCategoryCode(code);
	}
	
	private void setTotalComment(NewsDto dto) {
		dto.setTotalComments(commentRepository.countByNewsId(dto.getId()));
	}
	
}
