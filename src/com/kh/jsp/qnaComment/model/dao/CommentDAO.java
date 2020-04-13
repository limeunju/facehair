package com.kh.jsp.qnaComment.model.dao;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.qnaComment.model.vo.QnaComment;

public class CommentDAO {
	private Properties prop = new Properties();
	
	public CommentDAO() {
		String filePath = CommentDAO.class
					.getResource("/mappers/qComment.properties")
					.getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertComment(Connection con, QnaComment qco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qco.getQcwriter());
			pstmt.setInt(2, qco.getQno());
			pstmt.setString(3, qco.getQccontent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<QnaComment> selectList(Connection con, int qno) { //**** 이거 수상함 ****
		ArrayList<QnaComment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {	
				
				QnaComment qco = new QnaComment();
				
				qco.setQcno(rset.getInt(1));
				qco.setQcwriter(rset.getInt("QCWRITER"));
				qco.setQno(qno);
				qco.setQccontent(rset.getString("QCCONTENT"));
				qco.setQcdate(rset.getDate("QCDATE"));
				qco.setStatus(rset.getString("STATUS"));
				
				list.add(qco);	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int updateComment(Connection con, QnaComment qco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, qco.getQccontent());
			pstmt.setInt(2, qco.getQcno());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteComment(Connection con, int qcno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteComment");
		
		System.out.println("qcno 확인 : " + qcno);
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qcno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		return result;
	}
}
