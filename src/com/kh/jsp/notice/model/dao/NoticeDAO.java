package com.kh.jsp.notice.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.notice.model.vo.NoticeBoard;
import static com.kh.jsp.common.JDBCTemplate.*;

public class NoticeDAO {

	private Properties prop = new Properties();
	
	public NoticeDAO() {
		String filePath = NoticeDAO.class
						. getResource("/mappers/nBoard.properties")
						.getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	// 게시글 작성
	public int insertNotice(Connection con, NoticeBoard n) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, n.getnContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}
	
	// 리스트 전체조회
	public ArrayList<NoticeBoard> selectList(Connection con, int startRow, int endRow){
		ArrayList<NoticeBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				NoticeBoard n = new NoticeBoard();
				
				n.setBtype(rset.getInt("btype"));
				n.setBno(rset.getInt("bno"));
				n.setnTitle(rset.getString("ntitle"));
				n.setnContent(rset.getString("ncontent"));
				n.setnCount(rset.getInt("ncount"));
				n.setnDate(rset.getDate("ndate"));
				n.setStatus(rset.getString("status"));
				
				list.add(n);
			}
		} catch (SQLException e){
			e.printStackTrace();
		
		} finally {
			
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
		
	}
	// 리스트 카운트
	public int getListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1); // 2번으로 바꿔야할수도있음
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(stmt);
			
		}
		return result;
		
	}
	
	// 게시글 한 개 조회
	public NoticeBoard selectOne(Connection con, int bno) {
		NoticeBoard n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new NoticeBoard();
				
				n.setBtype(rset.getInt(1));
				n.setBno(bno);
				n.setnTitle(rset.getString(3));
				n.setnContent(rset.getString(4));
				n.setnCount(rset.getInt(5));
				n.setnDate(rset.getDate(6));
				n.setStatus(rset.getString(7));
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
		
	}
	
	// 게시글 조회수 증가
	public int addReadCount(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("addReadCount");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}
	
	// 게시글 수정
	public int updateNotice(Connection con, NoticeBoard n) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, n.getnContent());
			pstmt.setInt(3, n.getBno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 게시글 삭제
	public int deleteNotice(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try{
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		
		} finally {
			
			close(pstmt);
		}
		
		return result;
		
	}
	public int insertBno(Connection con) {
	      int result = 0;
	      Statement stmt = null;

	      try {
	         stmt = con.createStatement();

	         result = stmt.executeUpdate(" INSERT INTO BOARD VALUES(SEQ_BNO.NEXTVAL) ");

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(stmt);
	      }

	      return result;
	   }


	
}
