package com.project.quizapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {

	// Adding to Github
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String question_title;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correct_answer;
	private String difficulty_level;
	private String category;

	public String getOption(String answer) {
		String result = "";
		if (option1.equals(answer)) {
			result = "option1";
		}
		if (option2.equals(answer)) {
			result = "option2";
		}
		if (option3.equals(answer)) {
			result = "option3";
		}
		if (option4.equals(answer)) {
			result = "option4";
		}
		return result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public String getDifficulty_level() {
		return difficulty_level;
	}

	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Question() {

	}

	public Question(Integer id, String question_title, String option1, String option2, String option3, String option4,
			String correct_answer, String difficulty_level, String category) {
		super();
		this.id = id;
		this.question_title = question_title;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correct_answer = correct_answer;
		this.difficulty_level = difficulty_level;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question_title=" + question_title + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", correct_answer=" + correct_answer
				+ ", difficulty_level=" + difficulty_level + ", category=" + category + "]";
	}

}
