package com.kh.jsp.styletipComment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.styletipComment.model.vo.StyleTipComment;
import static com.kh.jsp.common.JDBCTemplate.*;

public class StyleTipCommentDAO {
	private Properties prop = new Properties();
	
	public StyleTipCommentDAO() {
		String filePath = StyleTipCommentDAO.class
				          .getResource("/mappers/styletipComment.properties")
				          .getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertComment(Connection con, StyleTipComment bco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bco.getCwriter());
			pstmt.setInt(2, bco.getBno());
			pstmt.setString(3, bco.getCcontent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<StyleTipComment> selectList(Connection con, int bno) {
		ArrayList<StyleTipComment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				StyleTipComment bco = new StyleTipComment();
				
				bco.setCno(rset.getInt(1));
				bco.setCwriter(rset.getInt("CWRITER"));
				bco.setBno(bno);
				bco.setCcontent(rset.getString("CCONTENT"));
				bco.setCdate(rset.getDate("CDATE"));
				bco.setStatus(rset.getString("STATUS"));
				
				list.add(bco);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int updateComment(Connection con, StyleTipComment bc) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bc.getCcontent());
			pstmt.setInt(2, bc.getCno());
			
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
}












