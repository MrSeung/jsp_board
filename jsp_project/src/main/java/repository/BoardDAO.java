package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList(PagingVO pvo);

	BoardVO selectOne(int bno);

	int update(BoardVO bvo4);

	int delete(int bno4);

	int size();

	List<BoardVO> search(PagingVO pvo1);

	String selectFileName(int bno);

}
