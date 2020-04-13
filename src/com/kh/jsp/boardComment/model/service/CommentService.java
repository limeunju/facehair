package com.kh.jsp.boardComment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.boardComment.model.dao.CommentDAO;
import com.kh.jsp.boardComment.model.vo.BoardComment;
import com.kh.jsp.member.model.vo.Member;

import static com.kh.jsp.common.JDBCTemplate.*;


public class CommentService {
	Connection con;
	
	private CommentDAO cdao = new CommentDAO();
	
	public int insertComment(BoardComment bco) {
		con = getConnection();
		
		int result = cdao.insertComment(con, bco);
		
		if(result>0) {
			commit(con);
		}else rollback(con);
		
		close(con);
		
		return result;

	}
	public ArrayList<Member> mselectList(int bno){
		con = getConnection();
		ArrayList<Member> list = cdao.mselectList(con, bno);
		close(con);
		return list;
	}
	public ArrayList<BoardComment> selectList(int bno){
		
		con = getConnection();
		
		ArrayList<BoardComment> list = cdao.selectList(con, bno);
			
		close(con);
		
		return list;
		
	}

	public int updateComment(BoardComment bco) {
		con = getConnection();
		int result = 0;
		
		result = cdao.updateComment(con, bco);
		
		if(result>0)commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
		public int deleteComment(int cno) {
			con = getConnection();
			int result = 0;
			
			result = cdao.deleteComment(con, cno);
			System.out.println("댓글삭제 서비스테스트확인");
			if(result>0)commit(con);
			else rollback(con);
			
			close(con);
			
			return result;
			
		}
	
	
	
	
	
	
	
	
	
	
}
