package dev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member {
	private int id;
	private String name;
	private String password;
	private String ban;
}
