package com.exam.service;

import java.util.List;

import com.exam.entities.Category;
import com.exam.entities.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public List<Quiz> getQuizes();
	public Quiz updateQuiz(Quiz quiz);
	public Quiz getQuiz(Long id);
	public void deleteQuiz(Long id);
	public List<Quiz> getQuizByCategory(Category category);
	public List<Quiz> getQuizByActive(Boolean bool);
	public List<Quiz> getQuizByActiveAndCategory(Boolean bool,Category category);

}
