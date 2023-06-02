package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.ReplyVO;
import orm.DatabaseBuilder;

public class ReplyDAOImpl implements ReplyDAO {
	private SqlSession sql;
	private String NS="ReplyMapper.";
	
	public ReplyDAOImpl() {
		new DatabaseBuilder();
		sql=DatabaseBuilder.getFactory().openSession();
	}	

	@Override
	public int insert(ReplyVO rvo) {
		
		int isOk=sql.insert(NS+"insert", rvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<ReplyVO> getList(int bno) {
		// TODO Auto-generated method stub
		return sql.selectList(NS+"list", bno);
	}

	@Override
	public int delete(int rno) {
		// TODO Auto-generated method stub
		int isOk=sql.delete(NS+"delete", rno);
		if(isOk>0) {
			sql.commit();
		}
		
		return isOk;
	}

	@Override
	public int update(ReplyVO rvo) {
		// TODO Auto-generated method stub
		int isOk=sql.update(NS+"update", rvo);
		if(isOk>0) {
			sql.commit();
		}
		
		return isOk;
	}

//	//수정하기 전 리스트 뽑아내던 메서드
//	@Override
//	public List<ReplyVO> selectList(int bno2) {
//		
////		return sql.selectList(NS+"list", bno2);
//		return null;
//	}
//
//	public List<ReplyVO> reList(int bno) {
//
//		return sql.selectList(NS+"list", bno);
//	}
//
//	@Override
//	public int delete(int rno) {
//		if(sql.delete(NS+"delete", rno)>0) {
//			sql.commit();
//		}
//
//		return sql.delete(NS+"delete", rno);
//	}

	

}
