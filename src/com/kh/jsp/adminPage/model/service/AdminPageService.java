package com.kh.jsp.adminPage.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.Creport.vo.Creport;
import com.kh.jsp.Qna.model.vo.Qna;
import com.kh.jsp.Report.model.vo.Report;
import com.kh.jsp.adminPage.model.dao.AdminDAO;

public class AdminPageService {
	private AdminDAO adao = new AdminDAO();
	Connection con;
	
	public Creport commentreSelectOne(int crepno) {
		con = getConnection();
		
		Creport c = adao.commentreSelectOne(con, crepno);
		
		close(con);
		
		return c;
	}
	
	public Report boardreSelectOne(int repno) {
		con = getConnection();
		
		Report r = adao.boardreSelectOne(con, repno);
		
		close(con);
		
		return r;
	}

	public Qna qnaSelectOne(int qno) {
		con = getConnection();
		
		Qna q = adao.qnaSelectOne(con, qno);
		
		close(con);
		
		return q;
	}
	
	public ArrayList<Report> selectBoardre(int currentPage, int limit) {
		con = getConnection();
		
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 10;
		
		ArrayList<Report> listR =adao.selectBoardre(con, startRow, endRow);
		
		close(con);
		
		return listR;
	}
	
	public ArrayList<Creport> selectCommentre(int currentPage, int limit) {
		con = getConnection();
		
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 10;
		
		ArrayList<Creport> listC =adao.selectCommentre(con, startRow, endRow);
		
		close(con);
		
		return listC;
	}
	
	public ArrayList<Qna> selectQNA(int currentPage, int limit) {
		con = getConnection();
		
		int startRow = (currentPage - 1) * limit;
		int endRow = startRow + 10;
		
		ArrayList<Qna> listQ = adao.selectQNA(con, startRow, endRow);
		
		close(con);
		
		return listQ;
	}

	public int getBListCount() {
		con = getConnection();
		
		int result = adao.getBListCount(con);
		
		close(con);
		
		return result;
	}

	public int getCListCount() {
		con = getConnection();
		
		int result = adao.getCListCount(con);
		
		close(con);
		
		return result;
	}

	public int getQListCount() {
		con = getConnection();
		
		int result = adao.getQListCount(con);
		
		close(con);
		
		return result;
	}
}
