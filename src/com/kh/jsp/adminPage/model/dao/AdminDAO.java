package com.kh.jsp.adminPage.model.dao;

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

import com.kh.jsp.Creport.vo.Creport;
import com.kh.jsp.Qna.model.vo.Qna;
import com.kh.jsp.Report.model.vo.Report;

public class AdminDAO {

	private Properties prop = new Properties();
	
	public AdminDAO(){
		String filePath = AdminDAO.class
						  .getResource("/mappers/adminPage.properties")
						  .getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public ArrayList<Report> selectBoardre(Connection con, int startRow, int endRow) {
		
		ArrayList<Report> listR = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardre");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			listR = new ArrayList<>();
			
			while(rset.next()) {
				Report r = new Report();
				r.setRepno(rset.getInt("REP_NO"));
				r.setBno(rset.getInt("BNO"));
				r.setRepcon(rset.getString("REP_CON"));;
				r.setRepdate(rset.getDate("REP_DATE"));
				
				listR.add(r);
				}
			
			} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		
		
			
			
		}
		return listR;
	}
	
	public ArrayList<Creport> selectCommentre(Connection con, int startRow, int endRow) {
		
		ArrayList<Creport> listC = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommentre");
		
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			listC = new ArrayList<>();
			
			while(rset.next()) {
				
				Creport c = new Creport();
				c.setCrepno(rset.getInt("CREP_NO"));				
				c.setCno(rset.getInt("CNO"));;
				c.setWriter(rset.getInt("WRITER"));
				c.setCrepcon(rset.getString("CREP_CON"));
				c.setCrepdate(rset.getDate("CREP_DATE"));
				
				listC.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		return listC;
	}
	
	public ArrayList<Qna> selectQNA(Connection con, int startRow, int endRow) {
		
		ArrayList<Qna> listQ = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQNA");
		
			try {
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, endRow);
				pstmt.setInt(2, startRow);
				
				rset = pstmt.executeQuery();
				
				listQ = new ArrayList<>();
				
				while(rset.next()) {
					Qna q = new Qna();
					
					q.setQno(rset.getInt("QNO"));
					q.setWriter(rset.getInt("WRITER"));
					q.setQtitle(rset.getString("QTITLE"));
					q.setQcontent(rset.getString("QCONTENT"));
					q.setQcount(rset.getInt("QCOUNT"));
					q.setQdate(rset.getDate("QDATE"));
					q.setStatus(rset.getString("STATUS"));
					
					listQ.add(q);
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
				
			} finally {
				close(rset);
				close(pstmt);
			}
		
		return listQ;
		
	}
	// 댓글 신고 게시물 하나 조회
	public Creport commentreSelectOne(Connection con, int crepno) {
		Creport c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			String sql = prop.getProperty("commentreSelectOne");

			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, crepno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Creport();
				
				c.setCrepno(crepno);
				c.setCno(rset.getInt("CNO"));
				c.setWriter(rset.getInt("WRITER"));
				c.setCrepcon(rset.getString("CREP_CON"));
				c.setCrepdate(rset.getDate("CREP_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
			
		return c;
	}
	// 게시물 신고 게시물 하나 조회
	public Report boardreSelectOne(Connection con, int repno) {
		Report r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
			
			try {
				String sql = prop.getProperty("boardreSelectOne");
			
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, repno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					r = new Report();
					
					r.setRepno(repno);
					r.setBno(rset.getInt("BNO"));
					r.setRepcon(rset.getString("REP_CON"));
					r.setRepdate(rset.getDate("REP_DATE"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return r;
	}
	// qna 게시물 하나 조회
	public Qna qnaSelectOne(Connection con, int qno) {
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			
			String sql = prop.getProperty("qnaSelectOne");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna();
				
				q.setQno(qno);
				q.setWriter(rset.getInt("WRITER"));
				q.setQtitle(rset.getString("QTITLE"));
				q.setQcontent(rset.getString("QCONTENT"));
				q.setQcount(rset.getInt("QCOUNT"));
				q.setQdate(rset.getDate("QDATE"));
				q.setStatus(rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}

	public int getBListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("bListCount");
		
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

	public int getCListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("cListCount");
		
		
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

	public int getQListCount(Connection con) {
		// TODO Auto-generated method stub
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("qListCount");
		
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
}
