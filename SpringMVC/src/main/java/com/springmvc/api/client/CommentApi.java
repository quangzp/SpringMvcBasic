package com.springmvc.api.client;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dto.CommentDto;
import com.springmvc.service.ICommentService;

@RestController(value = "commentApi-web")
public class CommentApi {
	@Autowired
	private ICommentService commentService;

	@GetMapping(value = "/api/comment")
	public ResponseEntity<CommentDto> show(@RequestParam(name = "page", required = true) Integer page,
			@RequestParam(name = "size", required = true) Integer size,
			@RequestParam(name = "newsId", required = true) Long newsId) {
		try {

			
			Sort sortByDate = new Sort(Direction.DESC, "modifiedDate");
			Pageable pageable = new PageRequest(page, size, sortByDate);
			
			return new ResponseEntity<CommentDto>(commentService.findAllByNewsId(newsId, pageable), HttpStatus.OK);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping(value = "/api/comment", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CommentDto> save(@RequestBody @Valid CommentDto dto, Errors errors) {
		if (!errors.hasErrors()) {
			try {
				CommentDto commentDto = commentService.save(dto);
				return new ResponseEntity<CommentDto>(commentDto, HttpStatus.OK);
			} catch (Exception e) {
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
