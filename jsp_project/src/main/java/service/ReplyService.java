package service;

import java.util.List;

import domain.ReplyVO;

public interface ReplyService {

	int post(ReplyVO rvo);

	List<ReplyVO> list(int bno);

	int remove(int rno);

	int modify(ReplyVO rvo);

}
