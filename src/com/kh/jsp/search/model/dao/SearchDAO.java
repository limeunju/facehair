package com.kh.jsp.search.model.dao;

import static com.kh.jsp.common.JDBCTemplate.close;

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

import com.kh.jsp.eventboard.model.vo.Eventboard;
import com.kh.jsp.notice.model.vo.NoticeBoard;
import com.kh.jsp.styletip.model.vo.StyleTip;
import com.kh.jsp.talk.model.vo.Talk;

public class SearchDAO {

	private Properties prop = new Properties();
	
	
	public SearchDAO() {
	String filePath = SearchDAO.class.getResource("/mappers/search.properties").getPath();
	
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	}
	
	public ArrayList<Talk> talkSearch(Connection con, int startRow, int endRow, String searchValue){
		
		ArrayList<Talk> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("talkSearch");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue);
			pstmt.setInt(3, endRow);
			pstmt.setInt(4, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				Talk t = new Talk();

				t.setBno(rset.getInt(1));
				t.setBtype(rset.getInt(2));
				t.setWriter(rset.getInt(3));
				t.settTitle(rset.getString(4));
				t.settContent(rset.getString(5));
				t.settCount(rset.getInt(6));
				t.settDate(rset.getTimestamp(7));
				t.settStatus(rset.getString(8));
								
				list.add(t);
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	public int talkSearchCount(Connection con, String searchValue) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("talkSearchCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue); 
		
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public ArrayList<Eventboard> eventSearch(Connection con, String searchValue){
		ArrayList<Eventboard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("eventSearch");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue);
			
			rset = pstmt.executeQuery();

			list = new ArrayList<>();
			
			while(rset.next()) {
				Eventboard eb = new Eventboard();
				
				eb.setBno(rset.getInt("BNO"));
				eb.setBtype(rset.getInt("BTYPE"));
				eb.setEtitle(rset.getString("ETITLE"));
				eb.setEcontent(rset.getString("ECONTENT"));
				eb.setEcount(rset.getInt("ECOUNT"));
				eb.setBfile(rset.getString("CHANGENAME"));
				eb.setEdate(rset.getDate("EDATE"));
				
				list.add(eb);
				
				System.out.println(eb);
				
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		return list;
	}
	public int eventSearchCount(Connection con, String searchValue) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("eventSearchCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue); 
		
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public ArrayList<NoticeBoard> noticeSearch(Connection con, int startRow, int endRow, String searchValue){
		ArrayList<NoticeBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeSearch");
		
		try {
			pstmt = con.prepareStatement(sql);
			

			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue);
			pstmt.setInt(3, endRow);
			pstmt.setInt(4, startRow);
			
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
	public int noticeSearchCount(Connection con, String searchValue) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeSearchCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue); 
		
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<StyleTip> styleTipSearch(Connection con, String searchValue) { // 완성
		ArrayList<StyleTip> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("styleTipSearch");
		
		try {
			pstmt = con.prepareStatement(sql);
			

			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue); 
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
	
	public int tipSearchCount(Connection con, String searchValue) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("tipSearchCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue); 
		
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
}
