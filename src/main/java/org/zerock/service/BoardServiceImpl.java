package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("BoardServiceImpl.register 메서드 실행");
		mapper.insertSelectKey(board);
	}
	
	@Override
	public BoardVO get(Long bno) {
		log.info("BoardServiceImpl.get 메서드 실행");
		return mapper.read(bno);
	}
	
	@Override
	public boolean modify(BoardVO board) {
		log.info("BoardServiceImpl.modify 메서드 실행");
		return mapper.update(board)==1;
	}
	
	@Override
	public boolean remove(Long bno) {
		log.info("BoardServiceImpl.remove 메서드 실행");
		return mapper.delete(bno)==1;
	}
	
	@Override
	public List<BoardVO> getlist(){
		log.info("BoardServiceImpl.getlist 메서드 실행");
		return mapper.getList()	;
	}

}
