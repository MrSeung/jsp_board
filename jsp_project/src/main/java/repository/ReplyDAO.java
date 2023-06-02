package repository;

import java.util.List;

import domain.ReplyVO;

public interface ReplyDAO {

	int insert(ReplyVO rvo);

	List<ReplyVO> getList(int bno);

	int delete(int rno);

	int update(ReplyVO rvo);

//	List<ReplyVO> selectList(int bno2);
//
//	int delete(int rno);

}
