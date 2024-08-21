package dev.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dev.service.cloud.DBConfigurer;

//DB와 관련된 공통적인 처리 코드들을 별도의 유틸 클래스로 분리
public class DBUtil {
	public static Connection getConnection(String argument) throws IOException {
		try {
			Properties properties = DBConfigurer.readProperties(argument);
			final String USER_NAME = properties.getProperty("USER_NAME");
			final String PASSWORD = properties.getProperty("PASSWORD");
			final String DB_URL = properties.getProperty("DB_URL");
			final String DATABASE = properties.getProperty("DATABASE");


			return DriverManager.getConnection(DB_URL + DATABASE, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
