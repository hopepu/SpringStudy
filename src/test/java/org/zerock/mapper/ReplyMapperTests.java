package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)  // 메서드별 테스트용 JUnit4
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참고할 파일
@Log4j2 
public class ReplyMapperTests {
	//테스트 전에 해당 번호의 게시물이 생각하는지 반드시 확인할 것
	private Long[] bnoArr = {312L, 311L, 308L, 307L, 306L};
		
	@Setter(onMethod_ = @Autowired) // 생성자 자동 주입
	private ReplyMapper mapper;
	
	@Test
	public void testList() {
		
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 6L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply");
		
		int count = mapper.update(vo);
		
		log.info("Update count : " + count);
	}
	
	@Test
	public void testDelete() {
		Long targetRno = 1L;
		
		mapper.delete(targetRno);
	}
	
	@Test
	public void testRead() {
		
		Long targetRno = 6L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
	}
		
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			//게시물의 번호
			
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}
	@Test // 메서드별로 테스트 JUnit
	public void testMapper() {
		
		log.info("ReplyMapperTests.testMapper() method activate : " + mapper);
	}	

}
