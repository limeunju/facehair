package com.kh.jsp.boardComment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.boardComment.model.vo.BoardComment;
import com.kh.jsp.eventboard.model.vo.Eventboard;
import com.kh.jsp.member.model.vo.Member;

import static com.kh.jsp.common.JDBCTemplate.*;

public class CommentDAO {
	
	Eventboard eb = new Eventboard();
	
	private Properties prop = new Properties();
	
	
	public CommentDAO() {
		String filePath = CommentDAO.class
				.getResource("/mappers/commentPark.properties")
				.getPath();
		try { 
			prop.load(new FileReader(filePath));
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public int insertComment(Connection con, BoardComment bco) {
		int result = 0;
		PreparedStatement pstmt = null;
		Eventboard eb = new Eventboard();
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bco.getCwriter());
			pstmt.setInt(2, bco.getBno());
			pstmt.setString(3, bco.getCcontent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Member> mselectList(Connection con, int bno){
		ArrayList<Member> mlist = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			mlist = new ArrayList<>();

			
			while(rset.next()) {
				

				Member mem = new Member();
				
		
				mem.setUserName(rset.getString("USERNAME"));
				
				
				mlist.add(mem);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mlist;
	}
	
	
	
	public ArrayList<BoardComment> selectList(Connection con, int bno){
		ArrayList<BoardComment> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
	
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();

			
			while(rset.next()) {
				
				BoardComment bco = new BoardComment();
				
				bco.setCno(rset.getInt(1));
				bco.setCwriter(rset.getInt("CWRITER"));
				bco.setBno(bno);
				bco.setCcontent(rset.getString("CCONTENT"));
				bco.setCdate(rset.getTimestamp("CDATE"));
				bco.setStatus(rset.getString("STATUS"));
				bco.setUserName(rset.getString("USERNAME"));
		
				list.add(bco);
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
	
		public int updateComment(Connection con, BoardComment bco){
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("updateComment");
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, bco.getCcontent());
				pstmt.setInt(2, bco.getCno());
				
				result = pstmt.executeUpdate();
			}
		catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
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
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(pstmt);
	}

	return result;
	}
	
	
}
