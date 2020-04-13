package com.kh.jsp.eventboard.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import static com.kh.jsp.common.JDBCTemplate.*;


import com.kh.jsp.eventboard.model.dao.EventDAO;
import com.kh.jsp.eventboard.model.vo.Attachment;
import com.kh.jsp.eventboard.model.vo.Eventboard;

public class EventService {
	Connection con;
	EventDAO edao = new EventDAO();
	
	public ArrayList<Eventboard> selectList(){
		con = getConnection();
		
		
		ArrayList<Eventboard> list = edao.selectList(con);
		
		close(con);
		
		return list;
	}
	
	public int insertEventboard(Eventboard eb, ArrayList<Attachment> list) {
		con = getConnection();
		
		int result = 0;
		
		int result_bno = edao.insertBno(con); 
		int eventInsertCheck = edao.insertEventboard(con, eb);
		int attachInsertCheck = 0;
		
		System.out.println("result_bno 확인 : " + result_bno);
		
		if(eventInsertCheck>0) {
			int currentBno = edao.selectCurrentBno(con);
			
		
		for(int i = 0;i<list.size();i++) {
			list.get(i).setBno(currentBno);
			
		}
		attachInsertCheck = edao.insertAttachment(con, list);
		
		}
		if(eventInsertCheck+result_bno>1 && attachInsertCheck == list.size()) {
			commit(con);
			result = 2;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
		
	}

	public HashMap<String, Object> selectOne(int bno){
		
		con = getConnection();
		
		HashMap<String, Object> hmap = null;
		System.out.println("서비스 도착");
		
		hmap = edao.selectOne(con, bno);
		
		if(hmap != null) {
			int result = edao.addReadCount(con, bno);
			
			if(result > 0) commit(con);
			else rollback(con);
		}
		
		close(con);
		
		return hmap;
	}
	public HashMap<String, Object> updateView(int bno) {
		con = getConnection();
		
		HashMap<String, Object> hmap = edao.selectOne(con, bno);
		
		close(con);
		
		return hmap;
	}

	
	
	public int updateEventboard(Eventboard eb, ArrayList list) {
		con = getConnection();
		
		int result = 0;
		int result1 = edao.updateEventboard(con, eb);
		int result2 = edao.updateAttachment(con, list);
		
		if(result1>0&&result2>0) {
			commit(con);
			result=1;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
		
	}
	public int deleteEventboard(int bno) {
		int result = 0;
		con = getConnection();
		
		int result1 = edao.deleteEventboard(con, bno);
		int result2 = edao.deleteAttachment(con, bno);
		
		if(result1>0&&result2>0) {
			commit(con);
			result=1;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
		
	}
	public int getListCount() {
		
		con = getConnection();
		int result = edao.getListCount(con);
		close(con);
		
		return result;
	}
	
	public ArrayList<Eventboard> top5() {
		con = getConnection();
		ArrayList<Eventboard> list = edao.top5(con);
		
		close(con);
	
		return list;
	}


	
	
}
