package com.kh.jsp.styletipComment.model.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.styletipComment.model.dao.StyleTipCommentDAO;
import com.kh.jsp.styletipComment.model.vo.StyleTipComment;

public class StyleTipCommentService {
	Connection con;
	private StyleTipCommentDAO cdao = new StyleTipCommentDAO();
	
	public int insertComment(StyleTipComment bco) {
		con = getConnection();
		
		int result = cdao.insertComment(con, bco);
		
		if ( result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<StyleTipComment> selectList(int bno) {
		con = getConnection();
		
		ArrayList<StyleTipComment> list = cdao.selectList(con, bno);
		
		close(con);
		
		return list;
	}

	public int updateComment(StyleTipComment bc) {
		con = getConnection();
		
		int result = cdao.updateComment(con, bc);
		
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

}




