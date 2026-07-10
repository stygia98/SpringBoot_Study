package com.hi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hi.domain.Board;
import com.hi.dto.BoardDTO;
import com.hi.repository.BoardRepo;

//BoardDTO -> Board
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepo boardRepo;
	
	@Override
	@Transactional(readOnly = true)
	public BoardDTO select(BoardDTO boardDTO) throws Exception {
		if (boardDTO.getBoardNo() <= 0) { return null; }

		Board board = new Board();
		board.setBoardNo(boardDTO.getBoardNo());

		Board board1 = boardRepo.select(board);
		boardDTO.setTitle(board1.getTitle());
		boardDTO.setContent(board1.getContent());
		boardDTO.setBoardNo(board1.getBoardNo());
		boardDTO.setWriter(board1.getWriter());
		boardDTO.setRegDate(board1.getRegDate());

		return boardDTO;
	}

	@Override
	@Transactional
	public boolean insert(BoardDTO boardDTO) throws Exception {
		if(boardDTO == null || boardDTO.getTitle() == null) { return true; }
		Board board = new Board();
		board.setBoardNo(boardDTO.getBoardNo()); //?
		board.setWriter(boardDTO.getWriter());
		board.setTitle(boardDTO.getTitle());
		board.setContent(boardDTO.getContent());

		return boardRepo.insert(board);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean update(BoardDTO boardDTO) throws Exception {
		if (boardDTO.getBoardNo() <= 0) { return false; }
		
		Board board = new Board();
		board.setBoardNo(boardDTO.getBoardNo());
		board.setWriter(boardDTO.getWriter());
		board.setTitle(boardDTO.getTitle());
		board.setContent(boardDTO.getContent());
		
		return boardRepo.update(board);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean delete(BoardDTO boardDTO) throws Exception {
		if (boardDTO.getBoardNo() <= 0) { return false; }
		
		Board board = new Board();
		board.setBoardNo(boardDTO.getBoardNo());
				
		return boardRepo.delete(board);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BoardDTO> list() throws Exception {
		List<Board> list = boardRepo.list();
		if (list.size() <= 0) { return null; }
		List<BoardDTO> list2 = new ArrayList<>();
		
		for (Board board : list) {
			BoardDTO boardDTO = new BoardDTO();
			
			boardDTO.setTitle(board.getTitle());
			boardDTO.setContent(board.getContent());
			boardDTO.setBoardNo(board.getBoardNo());
			boardDTO.setWriter(board.getWriter());
			boardDTO.setRegDate(board.getRegDate());

			list2.add(boardDTO);
		}
		
		return list2;
	}

}
