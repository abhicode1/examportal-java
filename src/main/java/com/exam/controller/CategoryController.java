package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entities.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService service;
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Category category)
	{
		return ResponseEntity.ok(service.addCategory(category));
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> get(@PathVariable("categoryId") Long id)
	{
		return ResponseEntity.ok(service.getCategory(id));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> gets()
	{
		return ResponseEntity.ok(service.getCategories());
	}
	@GetMapping("/update")
	public ResponseEntity<?> update(@RequestBody Category category)
	{
		return ResponseEntity.ok(service.updateCategory(category));
	}
	@DeleteMapping("/{categoryId}")
	public void delete(@PathVariable("categoryId") Long id)
	{
		service.deleteCategory(id);
	}

}
