package com.exam.service;

import java.util.List;

import com.exam.entities.Category;
import com.exam.entities.Quiz;

public interface CategoryService {
	public Category addCategory(Category ctg);
	public Category updateCategory(Category ctg);
	public List<Category> getCategories();
	public Category getCategory(Long id);
	public void deleteCategory(Long id);
	public List<Quiz> getQuizByCat(Long cid);

}
