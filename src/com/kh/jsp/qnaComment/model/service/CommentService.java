package com.kh.jsp.qnaComment.model.service;

import com.kh.jsp.qnaComment.model.dao.CommentDAO;
import com.kh.jsp.qnaComment.model.vo.QnaComment;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
public class CommentService {
	Connection con;
	
	private CommentDAO cdao = new CommentDAO();

	public int insertComment(QnaComment qco) {
		con = getConnection();
		
		int result = cdao.insertComment(con, qco);
		
		if(result > 0) {
			commit(con);
			
		} else {
			rollback(con);
			
		}
		close(con);
		
		return result;
	
		
	}
	
	public ArrayList<QnaComment> selectList(int qno) {
		con = getConnection();
		
		ArrayList<QnaComment> list = cdao.selectList(con, qno);
		
		close(con);
		
		return list;
		
	}

	public int updateComment(QnaComment qco) {
		con = getConnection();
		int result = cdao.updateComment(con, qco);
		
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
