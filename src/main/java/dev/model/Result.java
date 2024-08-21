package dev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class Result {
	private int id;
	private String name;
	private int score;
	private String result;
	
//	@Override
//	public String toString() {
//		return "Todo [id=" + id + ", subject=" + subject + ", type=" + type + ", question=" + question
//				+ ", answer=" + answer + "]";
//	}
}
