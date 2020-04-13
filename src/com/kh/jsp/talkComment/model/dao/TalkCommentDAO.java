package com.kh.jsp.talkComment.model.dao;

import static com.kh.jsp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.talkComment.model.vo.TalkComment;

public class TalkCommentDAO {

private Properties prop = new Properties();
	
	public TalkCommentDAO() {
		String filePath = TalkCommentDAO.class
				          .getResource("/mappers/talkComment.properties")
				          .getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertComment(Connection con, TalkComment tco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, tco.getCwriter());
			pstmt.setInt(2, tco.getBno());
			pstmt.setString(3, tco.getCcontent());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateComment(Connection con, TalkComment bco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bco.getCcontent());
			pstmt.setInt(2, bco.getCno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	public int deleteComment(Connection con, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteComment");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {			
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<TalkComment> selectList(Connection con, int bno) {
		ArrayList<TalkComment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				TalkComment tco = new TalkComment();
				
				tco.setCno(rset.getInt(1));
				tco.setBno(bno);
				tco.setCcontent(rset.getString("CCONTENT"));
				tco.setCwriter(rset.getInt("CWRITER"));
				tco.setCdate(rset.getTimestamp("CDATE"));
				tco.setStatus(rset.getString("STATUS"));
				
				list.add(tco);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


}
