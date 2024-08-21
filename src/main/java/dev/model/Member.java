package dev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
	private int id;
	private String name;
	private String password;
	private String ban;
	
}
