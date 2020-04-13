package com.kh.jsp.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.Qna.model.vo.Qna;
import com.kh.jsp.adminPage.model.service.AdminPageService;

/**
 * Servlet implementation class SelectQnaOneServlet
 */
@WebServlet("/adminSelectQnaOne.do")
public class AdminSelectQnaOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSelectQnaOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int qno = Integer.parseInt(request.getParameter("qno"));
		
		Qna q = new AdminPageService().qnaSelectOne(qno);
		
		String page = "";
		
		if(q != null) {
			page = "views/adminPage/adminPageQnaDetail.jsp";
			request.setAttribute("qna", q);
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
