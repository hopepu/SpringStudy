package net.kkwcloud.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.kkwcloud.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)		//메서드별로 테스트
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //참조할 파일

@Log4j2		//log출력용
public class DataSourceTests {
	
	@Setter(onMethod_=@Autowired)
	private DataSource dataSource;
	
	@Setter(onMethod_=@Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName()); 	// 클래스 이름을 출력
		//INFO  net.kkwcloud.persistence.DataSourceTests(testGetTime39) - com.sun.proxy.$Proxy36                                                  
		log.info(timeMapper.getTime());				// select 쿼리가 있는 메서드
		//INFO  net.kkwcloud.persistence.DataSourceTests(testGetTime40) - 2024-08-13 16:02:04
	}
	
	@Test
	public void testGetTimeXML() {
		log.info(timeMapper.getClass().getName());
		// INFO  net.kkwcloud.persistence.DataSourceTests(testGetTimeXML47) - com.sun.proxy.$Proxy36
		log.info(timeMapper.getTimeXML());
		// INFO  net.kkwcloud.persistence.DataSourceTests(testGetTimeXML48) - 2024-08-13 16:29:23
		
		
//		  log4jdbc 적용후 결과
//		|--------------------|
//		|sysdate             |
//		|--------------------|
//		|2024-08-13 16:40:32 |
//		|--------------------|
		
		
	}
	@Test
	
	public void testMyBatis() {
		// 동적쿼리문을 처리해주는 sql매핑용 테스트
		
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Connection connection = sqlSession.getConnection();
			log.info(sqlSession);
			log.info(connection);
			//INFO  net.kkwcloud.persistence.DataSourceTests(testMyBatis40) - org.apache.ibatis.session.defaults.DefaultSqlSession@7ea08277
			//INFO  net.kkwcloud.persistence.DataSourceTests(testMyBatis41) - HikariProxyConnection@1677840544 wrapping oracle.jdbc.driver.T4CConnection@6e92c6ad
			 
		} catch (Exception e) {
			fail(e.getMessage());
			fail("DataSourceTests.testMyBatis() 오류 발생");
		}
		
		
	}
	
	@Test
	public void testConnection() {
		
		Connection connection;
		try {
			connection = dataSource.getConnection();
			log.info(connection);//성공시 처리되는 로그
			//INFO  com.zaxxer.hikari.pool.HikariPool(checkFailFast554)
			//- HikariPool-1 - Added connection oracle.jdbc.driver.T4CConnection@4dd94a58
		} catch (SQLException e) {
			fail(e.getMessage());//실패시 처리되는 로그
		}
		
	}

}
