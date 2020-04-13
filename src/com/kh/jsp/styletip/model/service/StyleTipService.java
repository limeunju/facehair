package com.kh.jsp.styletip.model.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.jsp.styletip.model.dao.StyleTipDAO;
import com.kh.jsp.styletip.model.vo.StyleTip;

public class StyleTipService {
	Connection con;
	StyleTipDAO stdao = new StyleTipDAO();
	
	public ArrayList<StyleTip> selectList(int currentPage, int limit) { // 완성
		con = getConnection();
		
		int startRow = (currentPage - 1) * limit;  
		int endRow = startRow + 10;
		
		ArrayList<StyleTip> list = stdao.selectList(con, startRow, endRow);
		
		close(con);
		
		return list;
	}
	
	public int getListCount() {
		con = getConnection();
		
		int result = stdao.getListCount(con);
		
		close(con);
		
		return result;
	}
	

	public int insertStyleTip(StyleTip st) { // 완성
		
		con = getConnection();
		int result = 0;
		
		int result1 = stdao.insertBno(con);
		int result2 = stdao.insertStyleTip(con, st);
		
		if(result1 > 0 && result2 > 0) {
			
			commit(con);
			result = 1;
		} else rollback(con);
		
		close(con);
		
		return result;
	}

	public StyleTip selectOne(int bno) {
		
		con = getConnection();
		
		int result = stdao.addCount(con, bno);
		StyleTip st = null;
		
		if(result > 0) {
			st = stdao.selectOne(con, bno);
			commit(con);
		} else rollback(con);
		
		close(con);
		
		return st;
	}

	public StyleTip updateView(int bno) {
		con = getConnection();
		
		StyleTip st = stdao.selectOne(con, bno);
		
		close(con);
		
		return st;
	}
	
	public int updateStyleTip(StyleTip st) {
		
		con = getConnection();
		
		int result = stdao.updateStyleTip(con, st);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public int deleteStyleTip(int bno) {
		con = getConnection();
		int result = stdao.deleteStyleTip(con, bno); 
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
/*
	public int insertLike(int bno, int userNo) {
		
		con = getConnection();
		
		int result = stdao.insertLike(con, bno, userNo);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	public int deleteLike(int bno, int userNo) {
		
		con = getConnection();
		
		int result = stdao.deleteLike(con, bno, userNo);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
*/
	public int likeCount(int bno) {
		
		con = getConnection();
		
		int result = stdao.likeCount(con, bno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	public int likechk(int bno, int userNo) {
		con = getConnection();
		
		int chk = stdao.likechk(con, bno, userNo);
		
		close(con);

		return chk;
	}

	public int likeService(int bno, int userNo, int likechk) {
		con = getConnection();
		
		int result;
		if ( likechk == 0 ) {
			result = stdao.insertLike(con, bno, userNo);
		} else {
			result = stdao.deleteLike(con, bno, userNo);			
		}
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
}
