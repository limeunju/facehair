package com.kh.jsp.eventboard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.jsp.eventboard.model.service.EventService;
import com.kh.jsp.eventboard.model.vo.Eventboard;


/**
 * Servlet implementation class EventTopServlet
 */
@WebServlet("/top5.bo")
public class EventTopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventTopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventService bs = new EventService();
		
		ArrayList<Eventboard> toplist = bs.top5();
		
		String page = "";

		if(toplist != null) {
			page = "views/eventboard/eventBoardList.jsp";
			request.setAttribute("toplist", toplist);
			
		} else {
			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 목록 조회 에러!");			
		}
		
		request.getRequestDispatcher(page).forward(request, response);	
		/*
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());
		*/	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
