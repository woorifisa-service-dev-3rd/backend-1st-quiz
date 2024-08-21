package dev.service;

import java.util.Scanner;

import dev.model.Member;
import dev.util.PasswordHashing;

public class Login {
	
	public Member printNameAndPassword(){
		Scanner sc = new Scanner(System.in);
		Member member;
		PasswordHashing hasher = new PasswordHashing();
		
		while(true) {
			System.out.println("이름과 비밀번호를 선택해 주세요.");
			
			String name = sc.nextLine();
			// 입력 받은 password를 단방향 암호화 해시 처리한다
			String password = sc.nextLine();
			String hashedPassword = hasher.hashPassword(password);
			LoginDAO dao = new LoginDAO();
			member = dao.findByName(name, hashedPassword);
			
			if (member==null) {   
				System.out.println("서비스반에 없는 학생입니다 : (");
				continue;
			}
			if(member.getName().equals(name) && member.getPassword().equals(hashedPassword)) {
				System.out.println(member.getName()+"님, 환영합니다 : )"); 
				break;
			} 
		}
		return member;
	}
}