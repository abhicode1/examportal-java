package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entities.Question;
import com.exam.entities.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	@Autowired
	private QuestionService service;
	@Autowired
	private QuizService quizservice;
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Question ques)
	{
		return ResponseEntity.ok(service.addQuestion(ques));
	}
	
	@GetMapping("/{quesId}")
	public ResponseEntity<?> get(@PathVariable("quesId") Long id)
	{
		return ResponseEntity.ok(service.getQuestion(id));
	}
	
	@GetMapping("/quiz{quizId}")
	public ResponseEntity<?> gets(@PathVariable("quizId") Long id)
	{
		Quiz quiz = quizservice.getQuiz(id);
		List<Question> list = new ArrayList<>(quiz.getSet());
		if(list.size()>Integer.parseInt(quiz.getNoOfQuestions()))
		{
			list=list.subList(0, Integer.parseInt(quiz.getNoOfQuestions()));
		}
		Collections.shuffle(list);
		
		return ResponseEntity.ok(list);
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Question ques)
	{
		return ResponseEntity.ok(service.updateQuestion(ques));
	}
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long id)
	{
		service.deleteQuestion(id);
	}

}
