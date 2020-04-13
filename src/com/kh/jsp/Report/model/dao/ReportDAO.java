package com.kh.jsp.Report.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.jsp.Report.model.vo.Report;

import static com.kh.jsp.common.JDBCTemplate.*;


public class ReportDAO {
	
	private Properties prop = new Properties();
	
	public ReportDAO() {
		String filePath = ReportDAO.class
						.getResource("/mappers/report.properties")
						.getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public int insertReport(Connection con, Report r) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
			try {
				
				String sql = prop.getProperty("insertReport");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, r.getBno());
				pstmt.setString(2, r.getRepcon());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
	}
}
