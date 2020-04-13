package com.kh.jsp.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.Report.model.vo.Report;
import com.kh.jsp.adminPage.model.service.AdminPageService;

/**
 * Servlet implementation class SelectBoardReportOneServlet
 */
@WebServlet("/selectBoardReportOne.do")
public class SelectBoardReportOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardReportOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int repno = Integer.parseInt(request.getParameter("repno"));
		
		Report r = new AdminPageService().boardreSelectOne(repno);
	
		String page = "";
		
		if(r != null) {
			page = "views/adminPage/adminPageReportDetail.jsp";
			request.setAttribute("report", r);
			
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 에러");
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
