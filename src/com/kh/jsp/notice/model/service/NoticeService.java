package com.kh.jsp.notice.model.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.notice.model.dao.NoticeDAO;
import com.kh.jsp.notice.model.vo.NoticeBoard;

public class NoticeService {
	private NoticeDAO ndao = new NoticeDAO();
	Connection con;
	
	// insert
	public int insertNotice(NoticeBoard n) {
		con = getConnection();
		
		int result_bno = ndao.insertBno(con);
		int result = ndao.insertNotice(con, n);
		 
		
		if(result_bno + result > 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result_bno + result;
	}
	
	// selectOne
	public NoticeBoard selectOne(int bno) {
		con = getConnection();
		
		int result = ndao.addReadCount(con, bno);
		
		NoticeBoard n = null;
		
		if(result > 0) {
			n = ndao.selectOne(con, bno);
			
			if(n != null) commit(con);
		}
		
		else rollback(con);
		
		close(con);
		
		return n;
	}
	
	public NoticeBoard updateView(int bno) {
		
		con = getConnection();
		
		NoticeBoard n = ndao.selectOne(con, bno);
		
		close(con);
		
		return n;
		
	}
	
	// update
	public int updateNotice(NoticeBoard n) {
		
		con = getConnection();
		
		int result = ndao.updateNotice(con, n);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		return result;
	}
	
	// delete
	public int deleteNotice(int bno) {
		con = getConnection();
		
		int result = ndao.deleteNotice(con, bno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		return result;
		
	}
	
	// list
	public ArrayList<NoticeBoard> selectList(int currentPage, int limit) {
		con = getConnection();
		
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 10;
		
		ArrayList<NoticeBoard> list = ndao.selectList(con, startRow, endRow);
		
		close(con);
		
		return list;
	}
	
	// listcount
	public int getListCount() {
		con = getConnection();
		
		int result = ndao.getListCount(con);
		
		close(con);
		
		return result;
	}

	
	
}
