package com.exam.service;

import com.exam.entities.Question;


public interface QuestionService {
	
	public Question addQuestion(Question ques);

	public Question getQuestion(Long id);

	public Question updateQuestion(Question ques);

	public Question getQuestionfromQuiz(Long quizId);

	public void deleteQuestion(Long id);
}
