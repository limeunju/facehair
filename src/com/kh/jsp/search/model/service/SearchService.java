package com.kh.jsp.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.eventboard.model.vo.Eventboard;
import com.kh.jsp.notice.model.vo.NoticeBoard;
import com.kh.jsp.search.model.dao.SearchDAO;
import com.kh.jsp.styletip.model.vo.StyleTip;
import com.kh.jsp.talk.model.vo.Talk;

import static com.kh.jsp.common.JDBCTemplate.*;

public class SearchService {
	Connection con;
	SearchDAO sdao = new SearchDAO();
	
	public ArrayList<Talk> talkSearch(int currentPage, int limit, String searchValue) {
		con = getConnection();
		
		// 게시글 시작값과 끝값 미리 계산하기
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 20;
		
		ArrayList<Talk> list = sdao.talkSearch(con, startRow, endRow, searchValue);
		
		close(con);
		
		return list;
	}
	
	public int talkSearchCount(String searchValue) {
		
		con = getConnection();
		int result = sdao.talkSearchCount(con, searchValue);
		close(con);
		
		return result;
	}
	
	public ArrayList<Eventboard> eventSearch(String searchValue){
		con = getConnection();
		
		ArrayList<Eventboard> list = sdao.eventSearch(con, searchValue);
		
		close(con);
		
		return list;
	}
	
	public int eventSearchCount(String searchValue) {
		
		con = getConnection();
		int result = sdao.eventSearchCount(con, searchValue);
		close(con);
		
		return result;
		
		}
	
	
	public ArrayList<NoticeBoard> noticeSearch(int currentPage, int limit, String searchValue) {
		con = getConnection();
		
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 10;
		
		ArrayList<NoticeBoard> list = sdao.noticeSearch(con, startRow, endRow, searchValue);
		
		close(con);
		
		return list;
	}
	
	public int noticeSearchCount(String searchValue) {
		
		con = getConnection();
		int result = sdao.noticeSearchCount(con, searchValue);
		close(con);
		
		return result;
	}
	
	public ArrayList<StyleTip> styleTipSearch(String searchValue) { // 완성
		con = getConnection();
		
		ArrayList<StyleTip> list = sdao.styleTipSearch(con, searchValue);
		
		close(con);
		
		return list;
	}
	public int tipSearchCount(String searchValue) {
		
		con = getConnection();
		int result = sdao.tipSearchCount(con, searchValue);
		close(con);
		
		return result;
	}
	
	
	
}
