package com.kh.jsp.talk.model.dao;

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

import com.kh.jsp.talk.model.vo.Talk;
import static com.kh.jsp.common.JDBCTemplate.*;

public class TalkDAO {

	// 쿼리 조회용 프로퍼티 등록
	private Properties prop = new Properties();

	public TalkDAO() {
		String filePath = TalkDAO.class.getResource("/mappers/talk.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Board 시퀀스 추가 쿼리
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

	public int insertTalk(Connection con, Talk t) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertTalk");

		// Talk t 객체 값 확인
		System.out.println("Talk t 객체 값 확인" + t.toString());

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, t.getWriter());
			pstmt.setString(2, t.gettTitle());
			pstmt.setString(3, t.gettContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
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

	public ArrayList<Talk> selectList(Connection con, int startRow, int endRow){
		
		ArrayList<Talk> list = null;
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

	public Talk selectOne(Connection con, int bno) {
		Talk t = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				t = new Talk();
				
				t.setBno(rset.getInt(1));
				t.setBtype(rset.getInt(2));
				t.setWriter(rset.getInt(3));
				t.settTitle(rset.getString(4));
				t.settContent(rset.getString(5));
				t.settCount(rset.getInt(6));
				t.settDate(rset.getTimestamp(7));
				t.settStatus(rset.getString(8));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return t;
	}

	public int deleteTalk(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteTalk");
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

	public int updateTalk(Connection con, Talk t) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateTalk");
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, t.gettTitle());
			pstmt.setString(2, t.gettContent());
			pstmt.setInt(3, t.getBno());
						
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally	{
			close(pstmt);
		}		
		
		return result;
	}

}
