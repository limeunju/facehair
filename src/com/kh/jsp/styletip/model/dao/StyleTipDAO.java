package com.kh.jsp.styletip.model.dao;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.styletip.model.vo.StyleTip;

public class StyleTipDAO {
	private Properties prop = new Properties();

	public StyleTipDAO() {
		try {
			prop.load(new FileReader(StyleTipDAO.class
					.getResource("/mappers/styletip.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<StyleTip> selectList(Connection con, int startRow, int endRow) { // 완성
		ArrayList<StyleTip> list = null;
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
				
				StyleTip st = new StyleTip();
				
				st.setBtype(rset.getInt("BTYPE"));
				st.setBno(rset.getInt("BNO"));
				st.setTtitle(rset.getString("ttitle"));
				st.setTcontent(rset.getString("tcontent"));
				st.setTcount(rset.getInt("TCOUNT"));
				st.setTdate(rset.getDate("TDATE"));
				st.setTfilter(rset.getString("tfilter"));
				st.setStatus(rset.getString("STATUS"));
				
				list.add(st);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	
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

	public int insertBno(Connection con) { // 완성
		
		int result = 0;
		Statement stmt = null;
		String sql = prop.getProperty("insertBno");
		
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result; 
	}
	
	public int insertStyleTip(Connection con, StyleTip st) { // 완성
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertStyleTip");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, st.getTtitle());
			pstmt.setString(2, st.getTcontent());
			pstmt.setString(3, st.getTfilter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/*
	public int selectCurrentBno(Connection con) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT BNO FROM (SELECT * FROM TIP ORDER BY TDATE DESC) WHERE ROWNUM = 1";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	*/

	public StyleTip selectOne(Connection con, int bno) { // 완성
		
		StyleTip st = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				st = new StyleTip();
				st.setBtype(rset.getInt("btype"));
				st.setBno(bno);
				st.setTtitle(rset.getString("ttitle"));
				st.setTcontent(rset.getString("tcontent"));
				st.setTcount(rset.getInt("tcount"));
				st.setTdate(rset.getDate("tdate"));
				st.setStatus(rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return st;
	}
	
	public int addCount(Connection con, int bno) { // 완성
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("addCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	
	public int updateStyleTip(Connection con, StyleTip st) { // 완성
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateStyleTip");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, st.getTtitle());
			pstmt.setString(2, st.getTcontent());
			pstmt.setString(3, st.getTfilter());
			pstmt.setInt(4, st.getBno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	

	public int deleteStyleTip(Connection con, int bno) { // 완성
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteStyleTip");
		
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

	/*
	public ArrayList<StyleTip> filterList(Connection con, String tfilter) {
		
		ArrayList<StyleTip> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql;
		
		if(tfilter == "F") {
			sql = "SELECT * FROM TIP WHERE TFILTER = 'F' AND STATUS = 'N' ORDER BY BNO DESC";
		} else if(tfilter == "M") {
			sql = "SELECT * FROM TIP WHERE TFILTER = 'M' AND STATUS = 'N' ORDER BY BNO DESC";
		} else {
			sql = "SELECT * FROM TIP WHERE STATUS = 'N' ORDER BY BNO DESC";
		}
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				StyleTip st = new StyleTip();
				
				st.setBtype(rset.getInt("BTYPE"));
				st.setBno(rset.getInt("BNO"));
				st.setTtitle(rset.getString("ttitle"));
				st.setTcontent(rset.getString("tcontent"));
				st.setTcount(rset.getInt("TCOUNT"));
				st.setTdate(rset.getDate("TDATE"));
				st.setTfilter(tfilter);
				st.setStatus(rset.getString("STATUS"));
				
				list.add(st);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		return list;
		
	}
	*/

	public int insertLike(Connection con, int bno, int userNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("insertLike");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteLike(Connection con, int bno, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("deleteLike");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int likeCount(Connection con, int bno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("countLike");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT(*)");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	
	
	
	public int likechk(Connection con, int bno, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int chk = 0;
		String sql = "SELECT * FROM LIKEPOST WHERE WNO = ? AND BNO = ?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				chk = 1;
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return chk;
	}

}
