package com.kh.jsp.statistic.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static com.kh.jsp.common.JDBCTemplate.*;

public class StatisticDAO {
	private Properties prop = new Properties();

	public StatisticDAO() {
		try {
			prop.load(new FileReader(StatisticDAO.class
					.getResource("/mappers/statistics.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object selectGenderRatio(Connection con) {
		String[][] tmp = new String[2][2];
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGenderRatio");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while(rset.next()){
				int j = 0;
				tmp[i][j++] = rset.getString(1);
				tmp[i][j] = String.valueOf(rset.getInt(2));
				i++;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return tmp;
	}

	public Object selectMonthlyBoardData(Connection con) {
		int[] tmp = new int[36];
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMonthlyBoardData");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while(rset.next()){
				tmp[i] = rset.getInt(3);
				i++;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return tmp;
	}

	public Object selectMonthlyAvgData(Connection con) {
		int[] tmp = new int[12];
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMonthlyAvgData");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while(rset.next()){
				tmp[i] = rset.getInt(2);
				i++;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return tmp;
	}
}
