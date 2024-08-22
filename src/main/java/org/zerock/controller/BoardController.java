package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller							//spring have control
@Log4j2								//print out log
@RequestMapping("/board/*")			//http://localhost:80/board/?????
@AllArgsConstructor					//create constructor with all_field
public class BoardController {
	//field
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("BoardController.list method activate");
		model.addAttribute("list", service.getlist());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardController.register method activate");
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("BoardController.get method activate");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardController.modify method activate");
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		} else {
			rttr.addFlashAttribute("reuslt", "fail");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("BoardController.remove method activate");
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		} else {
			rttr.addFlashAttribute("result", "fail");
		}
		return "redirect:/board/list";
	}

}
