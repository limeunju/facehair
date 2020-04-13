package com.kh.jsp.talk.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.talk.model.dao.TalkDAO;
import com.kh.jsp.talk.model.vo.Talk;

public class TalkService {
	private TalkDAO tDao = new TalkDAO();
	private Connection con;

	public int insertTalk(Talk t) {
		con = getConnection();

		int result_bno = tDao.insertBno(con); 
		int result_talk = tDao.insertTalk(con, t);

		System.out.println("result_bno 확인 : " + result_bno);
		System.out.println("result_talk 확인 : " + result_talk );
		
		if (result_bno + result_talk > 1)
			commit(con);
		else
			rollback(con);

		close(con);

		return result_bno + result_talk;
	}

	public int getListCount() {
		con = getConnection();
		
		int result = tDao.getListCount(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Talk> selectList(int currentPage, int limit) {
		con = getConnection();
		
		// 게시글 시작값과 끝값 미리 계산하기
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 20;
		
		ArrayList<Talk> list = tDao.selectList(con, startRow, endRow);
		
		close(con);
		
		return list;
	}

	public Talk selectOne(int bno) {
		con = getConnection();
		
		int result = tDao.addReadCount(con, bno);
		
		Talk t = null;
		
		if(result > 0) {
			t = tDao.selectOne(con, bno);
			if(t != null) commit(con);
		}
		else rollback(con);
		
		close(con);
		
		return t;
	}

	public Talk updateView(int bno) {
		con = getConnection();
		
		Talk b = tDao.selectOne(con, bno);
		
		close(con);
		
		return b;
	}

	public int deleteTalk(int bno) {
		con = getConnection();
		
		int result = tDao.deleteTalk(con, bno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		return result;

	}

	public int updateTalk(Talk t) {
		con = getConnection();
		
		int result = tDao.updateTalk(con, t);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		return result;
	}
}
