package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	MemberVO login(MemberVO mvo2);

	int lastLogin(String id2);

	MemberVO detail(String id3);

	void modify(MemberVO vo);

	int remove(String id5);

	List<MemberVO> list();

}
