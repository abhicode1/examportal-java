package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.Category;
import com.exam.entities.Quiz;
import com.exam.repo.QuizRepo;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepo repo;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return repo.save(quiz);
	}

	
	@Override
	public List<Quiz> getQuizes() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return repo.save(quiz);
	}

	@Override
	public Quiz getQuiz(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void deleteQuiz(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}


	@Override
	public List<Quiz> getQuizByCategory(Category category) {
		// TODO Auto-generated method stub
		return repo.getQuizByCategory(category);
	}


	@Override
	public List<Quiz> getQuizByActive(Boolean bool) {
		// TODO Auto-generated method stub
		return repo.getQuizByActive(bool);
	}


	@Override
	public List<Quiz> getQuizByActiveAndCategory(Boolean bool, Category category) {
		// TODO Auto-generated method stub
		return repo.getQuizByActiveAndCategory(bool, category);
	}

}
