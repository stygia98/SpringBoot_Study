package com.hi.service;

import java.util.List;

import com.hi.dto.BoardDTO;

public interface BoardService {
	public boolean insert(BoardDTO BoardDTO) throws Exception;
	public boolean update(BoardDTO BoardDTO) throws Exception;
	public boolean delete(BoardDTO BoardDTO) throws Exception;
	public BoardDTO select(BoardDTO BoardDTO) throws Exception;
	public List<BoardDTO> list() throws Exception;
}
