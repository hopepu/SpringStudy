package net.kkwcloud.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests {// 1단계, 2단계, 5단계 테스트

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log.info("1단계 성공");
		} catch (Exception e) {
			//log.info("JDBCTest.static블럭 1단계 실패");
			fail("JDBCTest.static블럭 1단계 실패");
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConnection() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","book_ex", "book_ex");
			log.info(connection); // 객체의 주소를 출력 함
			log.info("2단계 성공");
		} catch (SQLException e) {
			fail("JDBCTests.testConnection() 2단계 실패");
			fail(e.getMessage());
		}
	}

}
