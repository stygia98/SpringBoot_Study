package com.hi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hi.dto.BoardDTO;
import com.hi.service.BoardService;



@Slf4j
@Controller
public class BoardController {
	//http://localhost:8080/board/insertForm
	
//	@Autowired
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

//	@Autowired
//	public BoardController(BoardService boardService) {
//		this.boardService = boardService;
//	}

//	private final BoardServiceImpl boardServiceImpl;
//	BoardController(BoardServiceImpl boardServiceImpl) {
//		this.boardServiceImpl = boardServiceImpl;
//	}



	// 게시판 입력창
	@RequestMapping(value = "/board/insertForm", method=RequestMethod.GET)
	public String boardInsertForm(BoardDTO boardDTO, Model model) {
		model.addAttribute("boardDTO", boardDTO);
		return "board/insertForm";
	}
	
	//게시판 입력내용 저장 요청
	@RequestMapping(value = "/board/insert", method=RequestMethod.POST)
	public String boardInsert(BoardDTO boardDTO, Model model, RedirectAttributes rttr) throws Exception {
		boolean result = boardService.insert(boardDTO);
		
		if (result == false) {
			rttr.addFlashAttribute("msg", "게시글 작성 실패, 다시 시도해주세요");
		} else {
			rttr.addFlashAttribute("msg", "게시글 작성 성공");
			rttr.addAttribute("writer", boardDTO.getWriter());
		}
		return "redirect:/board/list";
		//return (result == true) ? ("board/success") : ("board/fail");
	}
	
	//게시판 리스트 요청
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		List<BoardDTO> list = boardService.list();
		if (list == null || list.size() <= 0) { return "board/fail"; }
		model.addAttribute("list", list);
		
		return "board/list";
	}

	//게시글 내용 표기
	@RequestMapping(value = "/board/select", method=RequestMethod.GET)
	public String boardSelect(BoardDTO boardDTO, Model model) throws Exception {
		if (boardDTO.getBoardNo() <= 0) { return "board/fail"; }
		boardDTO = boardService.select(boardDTO);
		if(boardDTO == null) { return "board/fail"; }
		model.addAttribute("boardDTO", boardDTO);
		return "board/select";
	}

	//게시글 내용 표기
//	@RequestMapping(value = "/board/select", method=RequestMethod.GET)
//	@ResponseBody
//	public BoardDTO boardSelect(BoardDTO boardDTO, Model model) throws Exception {
//		boardDTO = boardServiceImpl.select(boardDTO);
//		return boardDTO;
//	}
	
	//게시글 삭제 요청
	@RequestMapping(value = "/board/delete", method=RequestMethod.GET)
	public String boardDelete(BoardDTO boardDTO, Model model) throws Exception {
		if (boardDTO.getBoardNo() <= 0) { return "board/fail"; }
		boolean result = boardService.delete(boardDTO);
		if(result == false) { return "board/fail"; }
		return "board/success";
	}
	
//	@RequestMapping(value = "/board/delete", method=RequestMethod.GET)
//	@ResponseBody
//	public Boolean boardDelete2(BoardDTO boardDTO, Model model) throws Exception {
//		boolean result = boardServiceImpl.delete(boardDTO);
//		return result;
//	}
	
	// 게시판 수정 요청 폼
	@RequestMapping(value = "/board/updateForm", method=RequestMethod.GET)
	public String boardUpdateForm(BoardDTO boardDTO, Model model) throws Exception {
		if (boardDTO.getBoardNo() <= 0) { return "board/fail"; }
		boardDTO = boardService.select(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/updateForm";
	}
	
//	@RequestMapping(value = "/board/updateForm", method=RequestMethod.GET)
//	@ResponseBody
//	public BoardDTO boardUpdateForm2(BoardDTO boardDTO, Model model) throws Exception {
//		boardDTO = boardServiceImpl.select(boardDTO);
//		return boardDTO;
//	}

	// 게시판 수정 요청
	@RequestMapping(value = "/board/update", method=RequestMethod.POST)
	public String boardUpdate(BoardDTO boardDTO, Model model) throws Exception {
		if (boardDTO.getBoardNo() <= 0) { return "board/fail"; }
		boolean result = boardService.update(boardDTO);
		if(result == false) { return "board/fail"; }
		return "board/success";
	}
	
//	@RequestMapping(value = "/board/update", method=RequestMethod.POST)
//	@ResponseBody
//	public Boolean boardUpdate2(BoardDTO boardDTO, Model model) throws Exception {
//		boolean result = boardServiceImpl.update(boardDTO);
//		return result;
//	}
	
}
