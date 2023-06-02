package repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	//NameSpace = SQL이 mapper를 구분하기 위한 이름
	//NameSpace.SQL 구문이름
	private String NS="MemberMapper.";
	
	public MemberDAOImpl() {
		//DB연결
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(MemberVO mvo) {
		// TODO Auto-generated method stub
		//sql.insert(NS+이름, 객체);
		int isOk = sql.insert(NS+"reg", mvo); // == sql.insert(MemberMapper.reg)
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo2) {
		log.info(">>> login DAO진입!");		
		return sql.selectOne(NS+"login", mvo2);
	}

	@Override
	public int lastLogin(String id2) {
		log.info(">>> logout DAO진입!");
		int isOk = sql.insert(NS+"logout", id2);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selectMember(String id3) {
		log.info(">>> modify DAO진입!");
		return sql.selectOne(NS+"modify", id3);
	}

	@Override
	public void update(MemberVO vo) {
		log.info(">>> update DAO진입!");
		int isOk = sql.update(NS+"update", vo);
		if(isOk>0) {
			sql.commit();
		}
	}

	@Override
	public int delete(String id5) {
		log.info(">>> delete DAO진입!");
		int isOk = sql.delete(NS+"del", id5);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<MemberVO> selectList() {
		log.info(">>> selectList DAO진입!");
		List<MemberVO> list=new ArrayList<MemberVO>();
		list=sql.selectList(NS+"list");
		return list;
	}

}
