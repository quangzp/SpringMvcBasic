package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.entity.NewsEntity;

@Component
public class NewsValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return NewsEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NewsEntity news = (NewsEntity) target;
		if(news.getId() == null) {
			if(news.getFile() == null) {
				errors.rejectValue("photoFile", "Upload image, please!");;
			}
		}
	}

}
