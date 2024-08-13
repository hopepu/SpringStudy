package net.kkwcloud.sample;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component				//스프링이 객체 관리해주세요 -> root-context에 context:component_scan 패키지 추가
@Data					//lombok이 DTO처럼 관리해주세요. 
public class Restaurant {
	
	// 필드
	@Setter(onMethod_ = @Autowired) // 자동으로 setChef()를 컴파일 시 생성한다.
	private Chef chef;				// setChef(chef)
	private String restaurantName;
	private Date openTime;
	private Date closeTime;
	
	
	// 생성자
	
	// 메서드

}
