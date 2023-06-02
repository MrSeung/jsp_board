package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private String NS="BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info(">>> insert DAO 진입!");
		int isOk=sql.insert(NS+"insert",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> selectList(PagingVO pvo) {
		log.info(">>> selectList DAO 진입!");
		return sql.selectList(NS+"list",pvo);
	}

	@Override
	public BoardVO selectOne(int bno) {
		log.info(">>> selectOne DAO 진입!");
		
		//조회수 업데이트
		if(sql.update(NS+"count",bno)>0) {
			sql.commit();
		}
		
		return sql.selectOne(NS+"detail", bno);
	}

	@Override
	public int update(BoardVO bvo4) {
		log.info(">>> update DAO 진입!");
		return sql.update(NS+"update",bvo4);
	}

	@Override
	public int delete(int bno4) {
		log.info(">>> delete DAO 진입!");
		return sql.delete(NS+"delete",bno4);
	}

	@Override
	public int size() {
		int size = (sql.selectList(NS+"size")).size();
		return size;
	}

	@Override
	public List<BoardVO> search(PagingVO pvo1) {
		// TODO Auto-generated method stub
		return sql.selectList(NS+"search",pvo1);
	}

	@Override
	public String selectFileName(int bno) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"fileName",bno);
	}


}
