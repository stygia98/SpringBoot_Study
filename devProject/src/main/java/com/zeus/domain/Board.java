package com.zeus.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

//@NoArgsConstructor
@Data
@ToString(exclude = {"regDate"})
@Builder
public class Board {
	@NonNull
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
}

//@RequiredArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode(of="boardNo")
//@ToString

//public class Board implements Serializable {
//	private static final long serialVersionUID = 1L;
//	@NonNull
//	private int boardNo;
//	private String title;
//	private String content;
//	private String writer;
//	private Date regDate;
//}
