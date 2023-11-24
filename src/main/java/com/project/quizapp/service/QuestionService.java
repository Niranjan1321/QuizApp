package com.project.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizapp.model.Question;
import com.project.quizapp.dao.QuestionDao;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
	}

	public List<Question> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(category);
	}

	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDao.save(question);
	}

	public void deleteQuestion(Integer id) {
		// TODO Auto-generated method stub
		questionDao.deleteById(id);
	}

	public ResponseEntity<List<Question>> getQuestionsByDifficulty(String difficulty) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(questionDao.findByDifficulty(difficulty), HttpStatus.OK);
	}

}
