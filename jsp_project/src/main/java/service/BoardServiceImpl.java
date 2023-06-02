package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import domain.ReplyVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;
import repository.ReplyDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao=new BoardDAOImpl();
		}
	
	@Override
	public int register(BoardVO bvo) {
		log.info(">>> register service 진입!");
		
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> list(PagingVO pvo) {
		log.info(">>> list service 진입!");
		//조회수 업데이트
		return bdao.selectList(pvo);
	}

	@Override
	public BoardVO detail(int bno) {
		log.info(">>> detail service 진입!");
		return bdao.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo4) {
		log.info(">>> modify service 진입!");
		return bdao.update(bvo4);
	}

	@Override
	public int remove(int bno4) {
		log.info(">>> remove service 진입!");
		return bdao.delete(bno4);
	}

	@Override
	public List<ReplyVO> reList(int bno) {
		ReplyDAOImpl rdao = new ReplyDAOImpl();
//		return rdao.reList(bno);
		return null;
	}

	@Override
	public int size() {
		return bdao.size();
	}

	@Override
	public List<BoardVO> search(PagingVO pvo1) {
		// TODO Auto-generated method stub
		return bdao.search(pvo1);
	}

	@Override
	public String getFileName(int bno) {
		// TODO Auto-generated method stub
		return bdao.selectFileName(bno);
	}


}
