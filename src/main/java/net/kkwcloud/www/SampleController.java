package net.kkwcloud.www;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import net.kkwcloud.domain.SampleDTO;
import net.kkwcloud.domain.SampleDTOList;
import net.kkwcloud.domain.TodoDTO;

@Controller
// servlet-context 	<context:component-scan base-package="net.kkwcloud.www" />가 코드를 관리
@RequestMapping("/sample/*")
// url create : http://localhost:80/sample/*
@Log4j2
public class SampleController {
	
	
//	@DataTimeFormat을 DTO필드에 몇시하면 아래 코드(@InitBinder)는 사용 안함.
//	@InitBinder //문자열을 날짜 형식으로 변경용
//	public void initBinder(WebDataBinder binder) {
//		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(simpleDateFormat, false));
//		
//	}
	
	
	@RequestMapping("") // http://localhost:80/sample/*
	public void basic() {
		log.info("SampleController.basic() 메서드 실행");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	// http://localhost:80/sample/basic
	// RequestMethod.GET : get 메서드로 호출
	// RequestMethod.POST : post 메서드로 호출
	public void basicGet() {
		log.info("SampleController.basicGet() get + post 메서드 실행");
	}

	@GetMapping("/basicOnlyGet")
	// http://localhost:80/sample/basicOnlyGet
	public void basicGetOnly() {
		log.info("SampleController.basicGet() get방식의 메서드 실행");
		// 메시지 파일 [/WEB-INF/views/sample/basicOnlyGet.jsp]을(를) 찾을 수 없습니다.

	}

	@PostMapping("/basicOnlyPost")
	// http://localhost:80/sample/basicOnlyPost
	public void basicPostOnly() {
		log.info("SampleController.basicPost() Pst방식의 메서드 실행");
		// 메시지 파일 [/WEB-INF/views/sample/basicOnlyPost.jsp]을(를) 찾을 수 없습니다.
	}

	@GetMapping("/ex01")
	// http://localhost:80/sample/ex01
	public String ex01(SampleDTO sampleDTO) {
		log.info("SampleController.ex01(SampleDTO sampleDTO) 메서드 실행" + sampleDTO);
		return "ex01";
		// /WEB-INF/view/ex01.jsp
	}

	@GetMapping("/ex02")
	// http://localhost:80/sample/ex02?id=cyj&age=34
	public String ex02(@RequestParam("id") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
		// /WEB-INF/view/ex02.jsp
	}

	// 리스트 처리
	@GetMapping("/ex02List")
	// http://localhost:80/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
		// /WEB-INF/view/ex02List.jsp
	}

	// 배열 처리
	@GetMapping("/ex02Array")
	// http://localhost:80/sample/ex02Array?ids=111&ids=222&ids=333
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
		// /WEB-INF/view/ex02Array.jsp
	}

	@GetMapping("/ex02Bean") // http://localhost:80/sample/ex02Bean?list%5B0%5D.name=kkw&list%5B0%5D.age=30
	public String ex02Bean(SampleDTOList list) {// 리스트 객체를 매개값으로 받음

		log.info("list dtos : " + list);

		return "ex02Bean";
	}
	
	//상단에서 만든 initBinder를 활용한 날짜 입력 -> DTO에서 처리
	@GetMapping("/ex03") // http://localhost:80/sample/ex03?title=study&dueDate=2024/08/14&check=true
	public String ex03(TodoDTO todoDTO) {
		log.info("todo : " + todoDTO);
		
		return "ex03";
	}

}
