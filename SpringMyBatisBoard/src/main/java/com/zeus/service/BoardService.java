package com.zeus.service;

import java.util.List;

import com.zeus.dto.BoardDTO;

public interface BoardService {
	public BoardDTO select(BoardDTO BoardDTO) throws Exception;
	public boolean insert(BoardDTO BoardDTO) throws Exception;
	public boolean update(BoardDTO BoardDTO) throws Exception;
	public boolean delete(BoardDTO BoardDTO) throws Exception;
	public List<BoardDTO> list() throws Exception;
	public List<BoardDTO> search(BoardDTO boardDTO) throws Exception;
}
