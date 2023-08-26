package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.Question;
import com.exam.entities.Quiz;
import com.exam.repo.QuestionRepo;
import com.exam.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepo repo;

	@Override
	public Question addQuestion(Question ques) {
		// TODO Auto-generated method stub
		return repo.save(ques);
	}

	@Override
	public Question getQuestion(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Question updateQuestion(Question ques) {
		// TODO Auto-generated method stub
		return repo.save(ques);
	}

	@Override
	public Question getQuestionfromQuiz(Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		return repo.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
