package com.project.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.quizapp.model.Question;
import com.project.quizapp.model.QuestionWrapper;
import com.project.quizapp.model.Quiz;
import com.project.quizapp.model.Response;
import com.project.quizapp.dao.QuestionDao;
import com.project.quizapp.dao.QuizDao;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		Quiz quiz = new Quiz();

		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);

		return new ResponseEntity<>("Success", HttpStatus.CREATED);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		int i = 0;
		int result = 0;
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		for(Response response : responses) {
			System.out.println("Option is " + questionsFromDB.get(i).getOption(questionsFromDB.get(i).getCorrect_answer()));
			if(response.getResponse().equals(questionsFromDB.get(i).getOption(questionsFromDB.get(i).getCorrect_answer()))) {
				++result;
			}
			i++;
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
