package dev.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dev.model.Member;
import dev.model.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Quiz {
	public void run(String args) {
		String[] str = { "자바", "자바스크립트", "리액트" };
		String[] subjectAndType = printSubjectAndType(str);
		printPrecautions();
//		List<Test> tests = findBySubjectAndType(subjectAndType[0],subjectAndType[1], args);
//		printTest(tests);
	}

	private String[] printSubjectAndType(String sb[]) {
		String[] temp = new String[2];
		Scanner sc = new Scanner(System.in);
		System.out.println("시험 과목을 선택해 주세요.");
		while (true) {
			System.out.println(sb[0] + ", " + sb[1] + ", " + sb[2]);
			String subject = sc.nextLine();
			if (subject.equals(sb[0]) || subject.equals(sb[1]) || subject.equals(sb[2])) {
				temp[0] = subject;
				break;
			} else {
				System.out.println("시험 과목을 정확하게 입력 해 주세요!");
			}
		}
		System.out.println("시험 유형을 선택해 주세요.");
		while (true) {
			System.out.println("4지선다, OX문제, 단답형");
			String type = sc.nextLine().trim();
			if (type.equals("4지선다") || type.equals("OX문제") || type.equals("단답형")) {
				temp[1] = type;
				break;
			} else {
				System.out.println("시험 유형을 정확하게 입력 해 주세요");
			}
		}
		return temp;
	}

	private void printPrecautions() {
		System.out.println("※주의사항※");
		System.out.println("각 문제당 제한시간이 설정되어 있습니다.");
		System.out.println("제한시간이 지나면 감점이 되니 주의해 주세요!");
	}

	private void printTest(List<Test> tests) {
		int score = 0;
		int testScore = 100 / tests.size();
		Scanner sc = new Scanner(System.in);
		for (Test test : tests) {
			long startTime = System.currentTimeMillis();
			String input;
			while (true) {
				System.out.println(test.getQuestion() + " (" + test.getType() + ")");
				if (test.getType().equals("4지선다")) {
					System.out.println("1번 : " + test.getOption_1());
					System.out.println("2번 : " + test.getOption_2());
					System.out.println("3번 : " + test.getOption_3());
					System.out.println("4번 : " + test.getOption_4());
					input = sc.nextLine();
					if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
						break;
					} else {
						System.out.println("정확한 숫자를 입력 해 주세요.");
					}
				} else if (test.getType().equals("OX문제")) {
					input = sc.nextLine();
					if (input.equals("O") || input.equals("X")) {
						break;
					}
				} else {
					input = sc.nextLine();
					if (!input.trim().equals(""))
						break;
				}
			}
			long endTime = System.currentTimeMillis();
			if (test.getAnswer().equals(input)) {
				if ((startTime - endTime) / 1000 > test.getTime()) {
					score += testScore/2;
				}
				else score += testScore;
			}
		}
	}
}
