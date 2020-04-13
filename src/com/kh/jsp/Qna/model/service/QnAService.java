package com.kh.jsp.Qna.model.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.Qna.model.dao.QnADAO;
import com.kh.jsp.Qna.model.vo.Qna;

public class QnAService {
	private QnADAO qdao = new QnADAO();
	Connection con;
	
	
	public int insertQnA(Qna q) {
		con = getConnection();
		
		int result = qdao.insertQnA(con, q);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}



	// list
	public ArrayList<Qna> selectList(int currentPage, int limit) {
		con = getConnection();
		
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 10;
		
		ArrayList<Qna> list = qdao.selectList(con, startRow, endRow);
		
		close(con);
		
		return list;
	}
	
	// listcount
	public int getListCount() {
		con = getConnection();
		
		int result = qdao.getListCount(con);
		
		close(con);
		
		return result;
	}

	// selectOne
	public Qna selectOne(int qno) {
		con = getConnection();
		
		int result = qdao.addReadCount(con, qno);
		
		Qna q = null;
		
		if(result > 0) {
			q = qdao.selectOne(con, qno);
			
			if(q != null) commit(con);
			
		}
		else rollback(con);
		
		close(con);
		
		return q;
	}

	// update
	public int updateQnA(Qna q) {
		con = getConnection();
		
		int result = qdao.updateQnA(con, q);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		return result;
	}



	public int deleteQnA(int qno) {
		con = getConnection();
		
		int result = qdao.deleteQnA(con, qno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		return result;
	}



	public Qna updateView(int qno) {
		con = getConnection();
		
		Qna q = qdao.selectOne(con, qno);
		
		close(con);
		
		return q;
	}
	
	
}
