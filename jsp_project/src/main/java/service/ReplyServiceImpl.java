package service;

import java.util.List;

import domain.ReplyVO;
import repository.ReplyDAO;
import repository.ReplyDAOImpl;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDAO rdao;
	
	public ReplyServiceImpl() {
		rdao=new ReplyDAOImpl();
	}
//	@Override
//	public int register(ReplyVO rvo) {
//		return rdao.insert(rvo);
//	}
//	@Override
//	public List<ReplyVO> list(int bno2) {
//		
//		return rdao.selectList(bno2);
//	}
//	@Override
//	public int remove(int rno) {
//		// TODO Auto-generated method stub
//		return rdao.delete(rno);
//	}
	@Override
	public int post(ReplyVO rvo) {
		// TODO Auto-generated method stub
		return rdao.insert(rvo);
	}
	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return rdao.getList(bno);
	}
	@Override
	public int remove(int rno) {
		// TODO Auto-generated method stub
		return rdao.delete(rno);
	}
	@Override
	public int modify(ReplyVO rvo) {
		// TODO Auto-generated method stub
		return rdao.update(rvo);
	}
}
