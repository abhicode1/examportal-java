package com.exam.controller;

import java.util.List;
import java.util.Map;

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

import com.exam.entities.Category;
import com.exam.entities.Question;
import com.exam.entities.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	@Autowired
	private QuizService service;
	@Autowired
	private QuestionService quesService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(service.addQuiz(quiz));
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<?> get(@PathVariable("quizId") Long id)
	{
		return ResponseEntity.ok(service.getQuiz(id));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> gets()
	{
		return ResponseEntity.ok(service.getQuizes());
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(service.updateQuiz(quiz));
	}
	@DeleteMapping("/{quizId}")
	public void delete(@PathVariable("quizId") Long id)
	{
		service.deleteQuiz(id);
		
	}
	@GetMapping("/category{catId}")
	public ResponseEntity<?> getQuizByCat(@PathVariable("catId") Long id)
	{
		Category category = new Category();
		category.setCid(id);
		return ResponseEntity.ok(service.getQuizByCategory(category));
	}
	@GetMapping("/active")
	public ResponseEntity<?> getQuizByActive()
	{
		return ResponseEntity.ok(service.getQuizByActive(true));
	}
	@GetMapping("/active{catId}")
	public ResponseEntity<?> getQuizByActiveCategory(@PathVariable("catId") Long id)
	{
		Category category = new Category();
		category.setCid(id);
		return ResponseEntity.ok(service.getQuizByActiveAndCategory(true,category));
	}
	@PostMapping("/quiz-eval")
	public ResponseEntity<?> getQuizEval(@RequestBody List<Question> question)
	{
		String result="Not Clear";
		 Integer attempted=0;
		 Integer correctans=0;
		 Integer marks=0;
		 Integer MM=0;
		 final Integer NOQ=question.size();
		 MM=Integer.parseInt(question.get(0).getQuiz().getMaxMarks());
		for(Question ques:question)
		{
			if(ques.getAnswervalue()!=null && ques.getAnswervalue().equals(quesService.getQuestion(ques.getQuesId()).getAnswer()))
			{
				attempted++;
		        correctans++;
		        marks+=MM/NOQ;
		           
			}
			else if(ques.getAnswervalue()!=null&& ques.getAnswervalue().trim()!="")
	         {
	           attempted++;
	         }
		}
		
		marks= Math. round(marks);    
	       if(!(marks<(0.6*MM))){
	         result = "Clear";
	       }
	      
		Map<String,Object> map = Map.of("Attempted",attempted,"Correctans",correctans,"Marks",marks,"Result",result);
		
		return ResponseEntity.ok(map);
	}
	

}
