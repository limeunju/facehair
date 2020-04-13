package com.kh.jsp.eventboard.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;


import com.kh.jsp.eventboard.model.vo.Attachment;
import com.kh.jsp.eventboard.model.vo.Eventboard;
import static com.kh.jsp.common.JDBCTemplate.*;




public class EventDAO {
	private Properties prop = new Properties();
	
	public  EventDAO() {
		try{
			prop.load(new FileReader(EventDAO.class
					.getResource("/mappers/event.properties").getPath()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Eventboard> selectList(Connection con){
		ArrayList<Eventboard> list = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
	
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

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
			close(stmt);
			
		}
		return list;
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

	public int insertEventboard(Connection con, Eventboard eb) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertEventboard");
			
			
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, eb.getEtitle());
			pstmt.setString(2, eb.getEcontent());
			pstmt.setString(3, eb.getBfile());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	

	
	public int selectCurrentBno(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCurrentBno");
		
		try {

			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
		
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return result;
		
	}
	
	public int insertAttachment(Connection con, ArrayList<Attachment> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			for(int i = 0; i<list.size(); i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, list.get(i).getBno());
				pstmt.setString(2, list.get(i).getOriginName());
				pstmt.setString(3, list.get(i).getChangeName());
				pstmt.setString(4, list.get(i).getFilePath());
			
				if(i==0) pstmt.setInt(5, 0);
				else pstmt.setInt(5, 1);
				
				result += pstmt.executeUpdate();
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	public HashMap<String, Object> selectOne(Connection con, int bno){
		HashMap<String, Object> hmap = null;
		
		Eventboard eb = null;
		ArrayList<Attachment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				
				eb = new Eventboard();
				eb.setBno(bno);
				eb.setBtype(rset.getInt("BTYPE"));
				eb.setEtitle(rset.getString("ETITLE"));
				eb.setEcontent(rset.getString("ECONTENT"));
				eb.setEcount(rset.getInt("ECOUNT"));
				eb.setEdate(rset.getDate("EDATE"));
				eb.setStatus(rset.getString("STATUS"));
				eb.setBfile(rset.getNString("BFILE"));
				
				Attachment at = new Attachment();
				
				at.setFno(rset.getInt("FNO"));
				at.setBno(bno);
				at.setOriginName(rset.getString("ORIGINNAME"));
				at.setChangeName(rset.getString("CHANGENAME"));
				at.setFilePath(rset.getString("FILEPATH"));
				at.setDownloadCount(rset.getInt("DOWNLOADCOUNT"));
				at.setFlevel(rset.getInt("FLEVEL"));
				at.setUploadDate(rset.getDate("UPLOADDATE"));
				at.setStatus(rset.getString("STATUS"));
				
				list.add(at);
				
			}
			hmap = new HashMap<>();
			hmap.put("eventboard", eb);
			hmap.put("attachment", list);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return hmap;
		
	}
	public int updateEventboard(Connection con, Eventboard eb) {
		int result = 0;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("updateEvent");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, eb.getEtitle());
			pstmt.setString(2, eb.getEcontent());
			pstmt.setInt(3, eb.getBno());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateAttachment(Connection con, ArrayList<Attachment> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAtt");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i<list.size();i++) {
				pstmt.setString(1, list.get(i).getOriginName());
				pstmt.setString(2, list.get(i).getChangeName());
				pstmt.setInt(3, list.get(i).getFno());
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int deleteEventboard(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteEvent");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
	

	public int deleteAttachment(Connection con, int bno) {
		
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteAtt");
		
		try {
			
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
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
	public int getListCount(Connection con) {
		int result = 0;
		Statement stmt= null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return result;
		
	}

	public ArrayList<Eventboard> top5(Connection con){
		
		ArrayList<Eventboard> list = null;
	
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTop5");
		
		try {
	
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

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
			close(stmt);
			
		}
		return list;
	}
	
}
