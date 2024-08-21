package dev.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dev.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import dev.model.Member;
import dev.model.Test;
import dev.service.QuizDAO;
import dev.util.AESCryptoUtil;
import dev.util.DBUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Quiz {

	public void run(String args) {
		String[] str = {"JAVA", "JAVASCRIPT", "REACT"};
		String[] subjectAndType = printSubjectAndType(str);
		printPrecautions();
		QuizDAO test = new QuizDAO();
		List<Test> tests = test.findBySubjectAndType(subjectAndType[0], subjectAndType[1], args);
		int score = printTest(tests);
		Member member = new Member(1,"신원섭","1234","서비스");
		Score findScore = test.findScoreByNameAndSubject(member.getName(), subjectAndType[0], args);
		if(findScore != null){
			//test.insert~~~~;?
		}
		else {
			test.updateByScore(member.getName(), subjectAndType[0], score, args);
		}
		String acceptance = printScoreAndAcceptance(score);
		test.insertResult(member.getName(), score, acceptance);

	}


	private String printScoreAndAcceptance(int score){
		String accep = "합격";
		if(score >= 60){
			System.out.println("축하합니다. 시험에 합격하셨습니다~~");
		} else{
			System.out.println("시험에 불합격 하셨습니다. 좀 더 노력하세요!");
			accep = "불합격";
		}
		System.out.println("점수는 " + score +"점 입니다.");
		return accep;
	}

	private String[] printSubjectAndType(String[] sb){
		String[] temp = new String[2];
		Scanner sc = new Scanner(System.in);
		System.out.println("시험 과목을 선택해 주세요.");
		while(true) {
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

		while(true){
			System.out.println("4지선다, OX문제, 단답형");
			String type = sc.nextLine().trim();
			if(type.equals("4지선다") || type.equals("OX문제") || type.equals("단답형")){
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int printTest(List<Test> tests) {
		double score = 0;
		double testScore = 100.0 / tests.size();
		Scanner sc = new Scanner(System.in);
		for (Test test : tests) {
			long startTime = System.currentTimeMillis();
			String input;
			while (true) {
				System.out.println(test.getQuestion() + " (" + test.getType() + " " + test.getTime()+"초)");
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
					}else {
						System.out.println("정확한 문자를 입력 해 주세요.");
					}
				} else {
					input = sc.nextLine();
					if (!input.trim().equals("")) {
						break;
					}else {
						System.out.println("정확한 문자를 입력 해 주세요.");
					}
				}
			}
			long endTime = System.currentTimeMillis();
			if (test.getAnswer().equals(input)) {
				System.out.println(test.getTime()+"초 중 "+(endTime - startTime) / 1000 + "초 지났습니다.");
				if ((endTime - startTime) / 1000 > test.getTime()) {
					score += testScore/2;
				}
				else score += testScore;
			}
		}
		return (int)Math.round(score);
	}
	
	
	
	
	
	
}
