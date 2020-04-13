package com.kh.jsp.thumbnail.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.jsp.thumbnail.model.dao.ThumbnailDAO;
import com.kh.jsp.thumbnail.model.vo.Attachment;
import com.kh.jsp.thumbnail.model.vo.Thumbnail;
import static com.kh.jsp.common.JDBCTemplate.*;

public class ThumbnailService {
	Connection con;
	ThumbnailDAO tdao = new ThumbnailDAO();
	
	public ArrayList<Thumbnail> selectList() {
		con = getConnection();
		
		ArrayList<Thumbnail> list = tdao.selectList(con);
		
		close(con);
		
		return list;
	}

	public int insertThumbnail(Thumbnail t, ArrayList<Attachment> list) {
		con = getConnection();
		int result = 0;
		
		// 1-1. 게시글 등록 insert SQL
		tdao.insertBoard(con);
		
		int boardInsertCheck = tdao.insertThumbnail(con, t);
		int attachInsertCheck = 0;		
		
		if( boardInsertCheck > 0 ) {
			// 1-2. 등록된 게시글의 번호 가져오기(최신 게시글 번호)
			int currentBno = tdao.selectCurrentBno(con);
			
			// 2. 첨부파일 등록 insert SQL (게시글 : BNO)	
			for(int i = 0; i < list.size(); i++) {
				list.get(i).setBno(currentBno);
			}
			
			attachInsertCheck = tdao.insertAttachment(con, list);
		}
		
		// 3. 두 SQL의 결과를 확인하여 commit or rollback
		if(boardInsertCheck > 0 && attachInsertCheck == list.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public HashMap<String, Object> selectOne(int bno) {
		con = getConnection();
		HashMap<String, Object> hmap = null;
		
		System.out.println("서비스 도착!");
		
		hmap = tdao.selectOne(con, bno);
		
		int result = tdao.addReadCount(con, bno);
		
		if(result > 0 ) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);		
		
		return hmap;
	}

	public HashMap<String, Object> updateView(int bno) {
		con = getConnection();
		HashMap<String, Object> hmap = tdao.selectOne(con, bno);
		
		close(con);
		
		return hmap;
	}

	public int updateThumbnail(Thumbnail t, ArrayList<Attachment> list) {
		con = getConnection();
		
		int result = 0;
		
		
		int result1 = tdao.updateThumbnail(con, t);
		
		int result2 = tdao.updateAttachment(con, list);
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteThumbnail(int bno) {
		int result = 0;
		con = getConnection();
		
		int result1 = tdao.deleteThumbnail(con, bno);
		
		int result2 = tdao.deleteAttachment(con, bno);
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

public int likeCount2(int bno) {
		
		con = getConnection();
		
		int result = tdao.likeCount2(con, bno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	public int likechk2(int bno, int userNo) {
		con = getConnection();
		
		int chk = tdao.likechk2(con, bno, userNo);
		
		close(con);

		return chk;
	}

	public int likeService2(int bno, int userNo, int likechk2) {
		con = getConnection();
		
		int result;
		if ( likechk2 == 0 ) {
			result = tdao.insertLike2(con, bno, userNo);
		} else {
			result = tdao.deleteLike2(con, bno, userNo);			
		}
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	}
	
	
	






