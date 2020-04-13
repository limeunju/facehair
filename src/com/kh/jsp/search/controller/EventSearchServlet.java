package com.kh.jsp.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.eventboard.model.service.EventService;
import com.kh.jsp.eventboard.model.vo.Eventboard;
import com.kh.jsp.search.model.service.SearchService;

/**
 * Servlet implementation class EventSearchListServlet
 */
@WebServlet("/eventSearch.do")
public class EventSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Eventboard> list = null;
		
		String searchValue = request.getParameter("search");

		list = new SearchService().eventSearch(searchValue);

		System.out.println("서블릿에 제대로 왔늠?");
		
		String page = "";
		
		if(list!=null) {
			page = "views/search/eventSearchView.jsp";
			request.setAttribute("list", list);
			
		}else {
			System.out.println("이벤트게시판 리스트 오류");
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
