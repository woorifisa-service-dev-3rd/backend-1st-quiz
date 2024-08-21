package dev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class Test {
	private int id;
	private String subject;
	private String type;
	private String question;
	private String answer;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", subject=" + subject + ", type=" + type + ", question=" + question
				+ ", answer=" + answer + "]";
	}
}
