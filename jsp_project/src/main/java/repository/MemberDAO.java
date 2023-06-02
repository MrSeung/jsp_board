package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo2);

	int lastLogin(String id2);

	MemberVO selectMember(String id3);

	void update(MemberVO vo);

	int delete(String id5);

	List<MemberVO> selectList();

}
