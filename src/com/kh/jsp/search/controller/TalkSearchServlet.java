package com.kh.jsp.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.search.model.service.SearchService;
import com.kh.jsp.talk.model.service.TalkService;
import com.kh.jsp.talk.model.vo.PageInfo;
import com.kh.jsp.talk.model.vo.Talk;

/**
 * Servlet implementation class TalkSearchListServlet
 */
@WebServlet("/talkSearch.do")
public class TalkSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TalkSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Talk> list = null;
		
		SearchService ss = new SearchService();
		
		String searchValue = request.getParameter("search");

		// -- 페이징 처리 (데이터를 일정량 씩 끊어서 읽어오는 기술) -- //
		
		int startPage; 
		// 각 페이지들의 시작점(1, 2, 3 . . . 10 / 11, 12 ,13 . . . 20)
		
		int endPage; 
		// 각 페이지들의 종료지점
		
		int maxPage;
		// 전체 게시글 기준 마지막 페이지

		int currentPage;
		// 현재 페이지
		
		int limit;
		// 페이지도 10개씩, 게시글도 10개씩 (제한)
		
		// 게시판은 첫 페이지가 항상 1로 시작한다.
		currentPage = 1;
		
		// 한 번에 표시할 내용
		limit = 20;
		
		// 만약에 사용자가 현재 페이지의 정보를 가지고 있다면, 해당 정보 가져오기
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//전체 게시글 수
		int listCount = ss.talkSearchCount(searchValue);
		
		System.out.println("서블릿 확인");

		
		System.out.println("수다방 전체 게시글 수 : " + listCount);
				
		maxPage = (int)((double)listCount/limit + 0.9);
		
		startPage = (int)((double)currentPage/limit + 0.99) * limit - 19;
		
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		list = ss.talkSearch(currentPage, limit, searchValue);
		
		String page = "";
		
		if(list != null) {
			
			PageInfo pi = new PageInfo(startPage, endPage, 
					      maxPage, currentPage, limit, listCount);
			
			page = "views/search/talkSearchView.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
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
