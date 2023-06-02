package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.MemberController;
import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;

	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}
	
	@Override
	public int register(MemberVO mvo) {
		log.info(">>> register service 진입!");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo2) {
		log.info(">>> login service 진입!");
		return mdao.selectOne(mvo2);
	}

	@Override
	public int lastLogin(String id2) {
		log.info(">>> logout service 진입!");
		return mdao.lastLogin(id2);
	}

	@Override
	public MemberVO detail(String id3) {
		log.info(">>> detail service 진입!");
		return mdao.selectMember(id3);
	}

	@Override
	public void modify(MemberVO vo) {
		log.info(">>> detail service 진입!");
		mdao.update(vo);
	}

	@Override
	public int remove(String id5) {
		log.info(">>> remove service 진입!");
		return mdao.delete(id5);
	}

	@Override
	public List<MemberVO> list() {
		log.info(">>> list service 진입!");
		return mdao.selectList();
	}

}
