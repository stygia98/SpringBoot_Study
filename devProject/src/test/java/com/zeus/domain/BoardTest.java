package com.zeus.domain;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {
	
	@Test
	public void test1() {
//		Board board = new Board();
//		board.setBoardNo(10);
//		board.setTitle("홍길동1");
		Board board = Board.builder().boardNo(1).title("홍길동1").content("홍길동2").writer("홍길동3").regDate(new Date()).build();
		System.out.printf("%d %s\n", board.getBoardNo(), board.getTitle());
	}
	
	@Test
	public void test2() {
//		Board board = new Board();
		Board board = Board.builder().boardNo(1).title("홍길동1").content("홍길동2").writer("홍길동3").regDate(new Date()).build();
		System.out.printf("%s\n", board.toString());
	}
	
}
