package com.kh.jsp.Report.model.service;

import java.sql.Connection;

import com.kh.jsp.Report.model.dao.ReportDAO;
import com.kh.jsp.Report.model.vo.Report;

import static com.kh.jsp.common.JDBCTemplate.*;

public class ReportService {
	private ReportDAO rdao = new ReportDAO();
	private Connection con;
	
	public int insertReport(Report r) {
		con = getConnection();
				
		int result = rdao.insertReport(con, r);
		
		if(result > 0) {
			commit(con);
			result = 1;
		} else rollback(con);
		
		close(con);

		return result;
	}
}
