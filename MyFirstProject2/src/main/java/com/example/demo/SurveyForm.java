package com.example.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SurveyForm {
	
	@Max(150)
	@Min(0)
	private int age;
	
	@NotNull
	private int satisfaction;
	
	@Size(min = 1, max = 100, message="1文字以上、100文字以下で入力してください")
	@NotNull
	private String comment;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String commnet) {
		this.comment = commnet;
	}

}
