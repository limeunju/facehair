package com.kh.jsp.Qna.model.dao;

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

import com.kh.jsp.Qna.model.vo.Qna;
import static com.kh.jsp.common.JDBCTemplate.*;
public class QnADAO {

	private Properties prop = new Properties();
	
	public QnADAO() {
		String filePath = QnADAO.class
						.getResource("/mappers/qBoard.properties")
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
	public int insertQnA(Connection con, Qna q) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQnA");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, q.getQtitle());
			pstmt.setString(2, q.getQcontent());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e){
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result;
		
	}
	
	// 리스트 전체조회
	public ArrayList<Qna> selectList(Connection con, int startRow, int endRow) {
		ArrayList<Qna> list = null;
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
				Qna q = new Qna();
				
				q.setQno(rset.getInt("qno"));
				q.setWriter(rset.getInt("writer"));
				q.setQtitle(rset.getString("qtitle"));
				q.setQcontent(rset.getString("qcontent"));
				q.setQcount(rset.getInt("qcount"));
				q.setQdate(rset.getDate("qdate"));
				q.setStatus(rset.getString("status"));
				
				list.add(q);
			}
		} catch (SQLException e){
			e.printStackTrace();
			
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
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
				result = rset.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		
		} finally {
			close(rset);
			close(stmt);
		}
		
		return result;
	}
	
	// 게시글 한 개 조회
	public Qna selectOne(Connection con, int qno) {
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna();
				
				q.setQno(qno);
				q.setWriter(rset.getInt(2));// 이거 수정해야할수도 있음
				q.setQtitle(rset.getString(3));
				q.setQcontent(rset.getString(4));
				q.setQcount(rset.getInt(5));
				q.setQdate(rset.getDate(6));
				q.setStatus(rset.getString(7));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
		
	}
	
	// 게시글 조회수 증가
	public int addReadCount(Connection con, int qno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("addReadCount");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		return result;
	}
	
	// 게시글 수정
	public int updateQnA(Connection con, Qna q) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateQna");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, q.getQtitle());
			pstmt.setString(2, q.getQcontent());
			pstmt.setInt(3, q.getQno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteQnA(Connection con, int qno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteQna");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
		
	}
}
