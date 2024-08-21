package dev.service;

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
	public void run() {
		String[] str = {"JAVA", "JAVASCRIPT", "REACT"};
		String[] subjectAndType = printSubjectAndType(str);
		System.out.println(subjectAndType);
		QuizDAO test = new QuizDAO();
		Connection connection = test.getConnection();
		test.findBySubjectAndType(subjectAndType[0], subjectAndType[1], connection);
		test.printBestPlayer(connection);
		
		
	}

	private String[] printSubjectAndType(String sb[]){
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
	
	
	
	
	
}
