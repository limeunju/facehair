package com.kh.jsp.talkComment.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.talkComment.model.dao.TalkCommentDAO;
import com.kh.jsp.talkComment.model.vo.TalkComment;

public class TalkCommentService {
	Connection con;
	private TalkCommentDAO cdao = new TalkCommentDAO();

	public int insertComment(TalkComment tco) {
		con = getConnection();
		
		int result = cdao.insertComment(con, tco);
		
		if ( result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int updateComment(TalkComment bco) {
		con = getConnection();
		
		int result = cdao.updateComment(con, bco);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteComment(int cno) {
		con = getConnection();
		
		int result = cdao.deleteComment(con, cno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<TalkComment> selectList(int bno) {
		con = getConnection();
		
		ArrayList<TalkComment> list = cdao.selectList(con, bno);
		
		close(con);
		
		return list;
	}


}
