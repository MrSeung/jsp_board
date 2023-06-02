package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;
import domain.ReplyVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> list(PagingVO pvo);

	BoardVO detail(int bno);

	int modify(BoardVO bvo4);

	int remove(int bno4);

	List<ReplyVO> reList(int bno);
	
	//글 목록 총 사이즈 반환
	int size();

	List<BoardVO> search(PagingVO pvo1);

	String getFileName(int bno);


}
