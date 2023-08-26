package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.Category;
import com.exam.entities.Quiz;
import com.exam.repo.CategoryRepo;
import com.exam.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired
	private CategoryRepo repo;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
		
	}

	@Override
	public Category updateCategory(Category ctg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return  repo.findAll();
	}

	@Override
	public Category getCategory(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

	@Override
	public List<Quiz> getQuizByCat(Long cid) {
		// TODO Auto-generated method stub
		return repo.getQuizByCid(cid);
	}

}
