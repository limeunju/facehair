package com.kh.jsp.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.Creport.vo.Creport;
import com.kh.jsp.adminPage.model.service.AdminPageService;

/**
 * Servlet implementation class SelectCommentReportOneServlet
 */
@WebServlet("/selectCommentReportOne.do")
public class SelectCommentReportOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCommentReportOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int crepno = Integer.parseInt(request.getParameter("crepno"));
		
		Creport c = new AdminPageService().commentreSelectOne(crepno);
		
		String page = "";
		
		if(c != null) {
			page = "views/adminPage/adminPageCreportDetail.jsp";
			request.setAttribute("creport", c);
			
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 에러!");
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
