package net.kkwcloud.sample;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component				//스프링이 객체 관리하게 한다.
@Data					//DTO 관리용 lombok
//@AllArgsConstructor		//모든것을 받는 생성자가 만들어짐
//@NoArgsConstructor		//기본생성자
public class Chef {
	
	private String name;
	private int age;
	private Date regDate;

}
