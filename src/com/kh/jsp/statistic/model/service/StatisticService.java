package com.kh.jsp.statistic.model.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.jsp.statistic.model.dao.StatisticDAO;
import com.sun.org.glassfish.external.statistics.Statistic;


public class StatisticService {

	Connection con;
	StatisticDAO stdao = new StatisticDAO();

	public HashMap<String, Object> selectMap() {
		con = getConnection();
		
		HashMap<String, Object> hmap = new HashMap<>();
		hmap.put("gender",stdao.selectGenderRatio(con));
		hmap.put("board",stdao.selectMonthlyBoardData(con));
		hmap.put("avg",stdao.selectMonthlyAvgData(con));
		
		close(con);
		
		return hmap;
	}
}
