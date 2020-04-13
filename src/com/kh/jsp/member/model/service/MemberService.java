package com.kh.jsp.member.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.jsp.member.model.dao.MemberDAO;
import com.kh.jsp.member.model.vo.Member;

public class MemberService {
	MemberDAO mDao = new MemberDAO();
	Connection con = null;

	public int insertMember(Member m) {
		con = getConnection();
		int result = mDao.insertMember(con, m);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public Member selectOne(Member m) {
		con = getConnection();
		Member result = mDao.selectOne(con, m);

		if (result != null)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public int updateMember(Member m) {
		con = getConnection();

		int result = mDao.updateMember(con, m);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public int deleteMember(String userId) {
con = getConnection();
		
		int result = mDao.deleteMember(con, userId);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int idDupCheck(String userId) {
		con = getConnection();
		
		int result = mDao.idDupCheck(con, userId);
		
		close(con);
		
		return result;
	}

	public int nameDupCheck(String name) {
		con = getConnection();
		
		int result = mDao.nameDupCheck(con, name);
		
		close(con);
		
		return result;
	}

	public int emailDupCheck(String email) {
		con = getConnection();
		
		int result = mDao.emailDupCheck(con, email);
		
		close(con);
		
		return result;
	}

}
