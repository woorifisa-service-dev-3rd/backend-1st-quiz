package dev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Score {
	private int id;
	private String name;
	private String subject;
	private int score;
	
}
