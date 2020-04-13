package com.kh.jsp.StyleComment.model.dao;

import static com.kh.jsp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.StyleComment.model.vo.StyleComment;

public class StyleCommentDAO {

private Properties prop = new Properties();
	
	public StyleCommentDAO() {
		String filePath = StyleCommentDAO.class
				          .getResource("/mappers/StyleComment.properties")
				          .getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertComment(Connection con, StyleComment sco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, sco.getCwriter());
			pstmt.setInt(2, sco.getBno());
			pstmt.setString(3, sco.getCcontent());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateComment(Connection con, StyleComment sco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, sco.getCcontent());
			pstmt.setInt(2, sco.getCno());
			
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

	public ArrayList<StyleComment> selectList(Connection con, int bno) {
		ArrayList<StyleComment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				StyleComment tco = new StyleComment();
				
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
