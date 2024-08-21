package dev.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import dev.model.Member;
import dev.model.Result;
import dev.model.Score;
import dev.model.Test;
//import dev.service.cloud.DBConfigurer;
import dev.util.DBUtil;

// DAO, Data Access Object의 줄임말
// 실제 DB에 접근하는 역할을 별도의 클래스로 분리
public class QuizDAO {

	public void updateByResult(String memberName, int score, String args) {
		// 조회 SQL
		final String selectQuery = "UPDATE Result set score = ? where name = ?";

		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {
			pstmt.setInt(1, score);
			pstmt.setString(2, memberName);
			pstmt.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public Result findResultByName(String memberName, String args) {

		// 조회 SQL
		final String selectQuery = "SELECT * FROM Result where name = ?";
		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {

			pstmt.setString(1, memberName);

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int score = rs.getInt("score");
					String result = rs.getString("result");
					return new Result(id, name, score, result);
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


	public List<Score> findScoreByName(String memberName, String args) {

		// 조회 SQL
		final String selectQuery = "SELECT * FROM Score where name = ?";
		List<Score> scores = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {

			pstmt.setString(1, memberName);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String subject = rs.getString("subject");
					int score = rs.getInt("score");
					scores.add(new Score(id, name, subject, score));
				}
				return scores;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertScore( String person,  String subject, int score, String args){
		final String insertTableQuery = "INSERT INTO Score (name, subject, score) VALUES (?,?,?);"; // 요부분 test를 사람이름 넣으면 됩니다.
		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(insertTableQuery);) {
			pstmt.setString(1, person);
			pstmt.setString(2, subject);
			pstmt.setInt(3, score);

			pstmt.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}


	public void insertResult(String name, int score, String result, String args){
		final String Query = "INSERT INTO Result(name, score, result) value(?,?,?)";
		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(Query);) {
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, result);
			pstmt.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}


	public Score findScoreByNameAndSubject(String memberName, String subjectInput, String args) {

		// 조회 SQL
		final String selectQuery = "SELECT * FROM Score where name = ? and subject = ?";
		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {

			pstmt.setString(1, memberName);
			pstmt.setString(2, subjectInput);

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String subject = rs.getString("subject");
					int score = rs.getInt("score");


					return new Score(id, name, subject, score);
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

	public void updateByScore(String memberName, String subject, int score, String args) {

		// 조회 SQL
		final String selectQuery = "UPDATE Score set score = ? where name = ? and subject = ?";

		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {
			pstmt.setInt(1, score);
			pstmt.setString(2, memberName);
			pstmt.setString(3, subject);
			pstmt.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	
	public List<Test> findBySubjectAndType(String subject, String type, String args) {
		List<Test> test = new ArrayList<>();
		// 조회 SQL
		final String selectQuery = "SELECT * FROM Test where subject = ? and type = ? ";

		// try() 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 명시하지 않아도 됨)
		// JDBC 객체 이외에 자원 반납이 필요한 다른 클래스들도 동일하게 사용 가능
		// 조건, AutoCloseable 인터페이스를 상속받은 인터페이스들만 사용 가능
		try (Connection connection = DBUtil.getConnection(args);
				PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {

			pstmt.setString(1, subject);
			pstmt.setString(2, type);

			try (ResultSet rs = pstmt.executeQuery();) {
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String subject_0 = rs.getString("subject");
					String type_0 = rs.getString("type");
					String question = rs.getString("question");
					String answer = rs.getString("answer");
					int time = rs.getInt("time");

					if(Objects.equals(type_0, "4지선다")) {
						String option_1 = rs.getString("option_1");
                        String option_2 = rs.getString("option_2");
                        String option_3 = rs.getString("option_3");
                        String option_4 = rs.getString("option_4");
						Test testObj = new Test(id, subject_0, type_0, question, answer, option_1, option_2, option_3, option_4, time);
                        test.add(testObj);
					}
					else {
						Test testObj = new Test(id, subject_0, type_0, question, answer, null, null, null, null, time);
						test.add(testObj);
					}
				}
				return test;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void printBestPlayer(String args) {
		final String selectQuery = "SELECT * FROM Result order by score desc, name asc limit 3";
		int count = 1;
		try (Connection connection = DBUtil.getConnection(args);
			 PreparedStatement pstmt = connection.prepareStatement(selectQuery);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while(rs.next()) {
					System.out.println(count + "등 : " + rs.getString("name") + "(" + rs.getInt("score") + ")");
					count ++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

