package com.kh.jsp.StyleComment.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.StyleComment.model.dao.StyleCommentDAO;
import com.kh.jsp.StyleComment.model.vo.StyleComment;

public class StyleCommentService {
	Connection con;
	private StyleCommentDAO cdao = new StyleCommentDAO();

	public int insertComment(StyleComment sco) {
		con = getConnection();
		
		int result = cdao.insertComment(con, sco);
		
		if ( result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int updateComment(StyleComment sco) {
		con = getConnection();
		
		int result = cdao.updateComment(con, sco);
		
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

	public ArrayList<StyleComment> selectList(int bno) {
		con = getConnection();
		
		ArrayList<StyleComment> list = cdao.selectList(con, bno);
		
		close(con);
		
		return list;
	}


}
