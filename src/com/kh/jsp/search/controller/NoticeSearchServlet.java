package com.kh.jsp.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.notice.model.vo.NoticeBoard;
import com.kh.jsp.notice.model.vo.PageInfo;
import com.kh.jsp.search.model.service.SearchService;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/noticeSearch.do")
public class NoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<NoticeBoard> list = null;
		
		SearchService ss = new SearchService();
		
		String searchValue = request.getParameter("search");

		System.out.println(searchValue);
		
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		
		currentPage = 1;
		
		limit = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount = ss.noticeSearchCount(searchValue);
		
		System.out.println("전체 게시글 수 : " + listCount);
		
		maxPage = (int)((double)listCount/limit + 0.9);
		startPage = (int)((double)currentPage/limit + 0.9) * limit - 9;
		endPage = startPage + limit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		
		list = ss.noticeSearch(currentPage, limit, searchValue);
		System.out.println("서블릿 확인");
		
		String page = "";
		
		if(list != null) {
			PageInfo pi = new PageInfo(startPage, endPage,
					maxPage, currentPage, limit, listCount);
			
			page = "views/search/noticeSearchView.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 목록 조회 에러");
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
