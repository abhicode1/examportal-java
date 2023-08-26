package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entities.Category;
import com.exam.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {
	List<Quiz> getQuizByCategory(Category category);
	List<Quiz> getQuizByActive(Boolean bool);
	List<Quiz> getQuizByActiveAndCategory(Boolean bool,Category category);

}
