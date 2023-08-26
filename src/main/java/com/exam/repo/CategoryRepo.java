package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entities.Category;
import com.exam.entities.Quiz;

public interface CategoryRepo extends JpaRepository<Category, Long> {
	List<Quiz> getQuizByCid(Long cid);
}
