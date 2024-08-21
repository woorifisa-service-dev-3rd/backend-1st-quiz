package dev.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import dev.model.Member;
import dev.model.Test;
import dev.service.cloud.DBConfigurer;
import dev.util.AESCryptoUtil;
import dev.util.DBUtil;

// DAO, Data Access Object의 줄임말
// 실제 DB에 접근하는 역할을 별도의 클래스로 분리
public class QuizDAO {

	// JDK 7버전 이전 방식
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;


	public Member findByName(String memberName,String InputPassword, String args) {
		
		// 조회 SQL
		final String selectQuery = "SELECT * FROM Member where name = ? and password = ?";

		// try() 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 명시하지 않아도 됨)
		// JDBC 객체 이외에 자원 반납이 필요한 다른 클래스들도 동일하게 사용 가능
		// 조건, AutoCloseable 인터페이스를 상속받은 인터페이스들만 사용 가능

		try (Connection connection = DBUtil.getConnection(args);
				PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {

			pstmt.setString(1, memberName);
			pstmt.setString(2, InputPassword);


			try (ResultSet rs = pstmt.executeQuery();) {
				SecretKey key = AESCryptoUtil.getKey();
				IvParameterSpec ivParameterSpec = AESCryptoUtil.getIv();
				String specName = "AES/CBC/PKCS5Padding";
				if (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
//					password = AESCryptoUtil.decrypt(specName, key, ivParameterSpec, password);
					String ban = rs.getString("ban");


					return new Member(id, name, password, ban);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	public List<Test> findBySubjectAndType(String subject, String type) {
//		
//		// 조회 SQL
//		final String selectQuery = "SELECT * FROM Member where subject = ? and type = ?";
//
//		// try() 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 명시하지 않아도 됨)
//		// JDBC 객체 이외에 자원 반납이 필요한 다른 클래스들도 동일하게 사용 가능
//		// 조건, AutoCloseable 인터페이스를 상속받은 인터페이스들만 사용 가능
//
//		try (Connection connection = DBUtil.getConnection(selectQuery);
//				PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {
//
//			pstmt.setString(1, memberName);
//
//			try (ResultSet rs = pstmt.executeQuery();) {
//				SecretKey key = AESCryptoUtil.getKey();
//				IvParameterSpec ivParameterSpec = AESCryptoUtil.getIv();
//				String specName = "AES/CBC/PKCS5Padding";
//				if (rs.next()) {
//					int id = rs.getInt("id");
//					String name = rs.getString("name");
//					String password = rs.getString("password");
//					password = AESCryptoUtil.decrypt(specName, key, ivParameterSpec, password);
//					String ban = rs.getString("ban");
//
//
//					return new Member(id, name, password, ban);
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
