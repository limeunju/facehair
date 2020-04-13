package com.kh.jsp.Qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.notice.model.vo.PageInfo;
import com.kh.jsp.Qna.model.service.QnAService;
import com.kh.jsp.Qna.model.vo.Qna;

/**
 * Servlet implementation class SelectListQnAServlet
 */
@WebServlet("/selectList.qn")
public class SelectListQnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectListQnAServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Qna> list = null;
		QnAService qs = new QnAService();

		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;

		currentPage = 1;

		limit = 10;

		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount = qs.getListCount();

		maxPage = (int) ((double) listCount / limit + 0.9);
		startPage = (int) ((double) currentPage / limit + 0.9) * limit - 9;
		endPage = startPage + limit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		list = qs.selectList(currentPage, limit);

		String page = "";

		if (list != null) {
			PageInfo pi = new PageInfo(startPage, endPage, maxPage, currentPage, limit, listCount);

			page = "views/qna/qnaBoardList.jsp";// 경로지정해줘야함
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {

			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 목록 조회 에러");
		}

		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
