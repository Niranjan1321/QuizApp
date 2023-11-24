package com.project.quizapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizapp.Question;
import com.project.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("category/{category}")
	public  ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		try {
			return new ResponseEntity<>(questionService.getQuestionsByCategory(category), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("difficulty/{difficulty}")
	public  ResponseEntity<List<Question>> getQuestionsByDifficulty(@PathVariable String difficulty){
		try {
			return questionService.getQuestionsByDifficulty(difficulty);
		}
		catch(Exception e) {
			return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping()
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		questionService.addQuestion(question);
		try {
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
		try {
			questionService.deleteQuestion(id);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Error in Deleting", HttpStatus.BAD_REQUEST);
		}
		
	}

}
