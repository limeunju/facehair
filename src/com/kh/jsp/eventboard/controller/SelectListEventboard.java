package com.kh.jsp.eventboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.eventboard.model.service.EventService;
import com.kh.jsp.eventboard.model.vo.Eventboard;


/**
 * Servlet implementation class SelectListEventboard
 */
@WebServlet("/ListEventboard.do")
public class SelectListEventboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectListEventboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Eventboard> list = null;
		list = new EventService().selectList();
		ArrayList<Eventboard> toplist = new EventService().top5();
		
		System.out.println("서블릿에 제대로 왔늠?");
		
		String page = "";

		if(list != null) {
			page = "views/eventboard/eventBoardList.jsp";
			request.setAttribute("toplist", toplist);
			request.setAttribute("list", list);
			
		} else {
			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 목록 조회 에러!");			
		}
		
		request.getRequestDispatcher(page).forward(request, response);		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
