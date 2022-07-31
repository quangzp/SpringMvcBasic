package com.springmvc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.springmvc.repository.INewsRepository;
import com.springmvc.service.INewsService;

@Service
public class NewsService implements INewsService {

	@Autowired
	private INewsRepository newsRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private INewsMapper mapper;

	@Autowired
	private Cloudinary cloudinary;

	@Override
	public List<NewsDto> findAll(Pageable pageable) {
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		List<NewsDto> result = new ArrayList<>();
		for (NewsEntity entity : entities) {
			NewsDto dto = mapper.toDto(entity);
			dto.setCategoryCode(dto.getCategory().getCode());
			dto.setThumbnail(entity.getThumbnail());
			result.add(dto);
		}

		return result;
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
	@Transactional
	public NewsDto save(NewsDto dto, MultipartFile file) {

		if (file != null) {
			dto.setPhotoFile(file);
			try {
				Map resp = cloudinary.uploader().upload(dto.getPhotoFile().getBytes(),
						ObjectUtils.asMap("public_id", dto.getSlug(), "resource_type", "auto"));
				dto.setThumbnail((String) resp.get("secure_url"));

			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());

			}
		}
		NewsEntity newsEntity = new NewsEntity();
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
	@Transactional
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
}
