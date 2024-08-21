package dev.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import dev.model.Member;
import dev.util.DBUtil;

public class LoginDAO {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public Member findByName(String name, String hashedPassword, String args) {

		// 조회 SQL
		final String selectQuery = "SELECT * FROM Member where name = ? and password = ?";

		// try() 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 명시하지 않아도 됨)
		// JDBC 객체 이외에 자원 반납이 필요한 다른 클래스들도 동일하게 사용 가능
		// 조건, AutoCloseable 인터페이스를 상속받은 인터페이스들만 사용 가능

		try (Connection connection = DBUtil.getConnection(args);
				PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {
				pstmt.setString(1, name);
				pstmt.setString(2, hashedPassword);

			try (ResultSet rs = pstmt.executeQuery();) {

				if (rs.next()) {
					int id = rs.getInt("id");
					String ban = rs.getString("ban");
					return new Member(id, name, hashedPassword, ban);
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
}
