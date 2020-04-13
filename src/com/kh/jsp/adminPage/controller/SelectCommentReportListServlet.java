package com.kh.jsp.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.Creport.vo.Creport;
import com.kh.jsp.adminPage.model.service.AdminPageService;
import com.kh.jsp.adminPage.model.vo.PageInfo;

/**
 * Servlet implementation class SelectCommentReportServlet
 */
@WebServlet("/selectCommentReportList.do")
public class SelectCommentReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCommentReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Creport> listC = null;
		AdminPageService as = new AdminPageService();
		
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		
		currentPage = 1;
		
		limit = 10;
		
		if(request.getParameter("currentPage") != null ) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount = as.getCListCount();
		
		System.out.println("전체 게시글 수 : " + listCount);
		
		maxPage = (int)((double)listCount/limit + 0.9);
		
		startPage = (int)((double)currentPage/limit + 0.9) * limit - 9;
	
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		listC = as.selectCommentre(currentPage, limit);
		
		String page = "";
		
		if(listC != null) {
			
			PageInfo pi = new PageInfo(startPage, endPage,
						maxPage, currentPage, limit, listCount);
			
			page = "views/adminPage/adminPageCreport.jsp";
			request.setAttribute("list", listC);
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
