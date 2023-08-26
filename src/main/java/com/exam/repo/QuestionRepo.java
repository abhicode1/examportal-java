package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entities.Question;
import com.exam.entities.Quiz;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	public Question findByQuiz(Quiz quiz);

}
