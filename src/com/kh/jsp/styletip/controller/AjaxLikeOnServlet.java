package com.kh.jsp.styletip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.jsp.styletip.model.service.StyleTipService;

/**
 * Servlet implementation class AjaxLikeServlet
 */
@WebServlet("/likeon.st")
public class AjaxLikeOnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLikeOnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int likechk = Integer.parseInt(request.getParameter("likechk"));
		
		StyleTipService sts = new StyleTipService();
		
		int result = sts.likeService(bno, userNo, likechk);
		if(result > 0) {
			if(likechk == 0) likechk = 1;
			else likechk = 0;
		}
		System.out.println("likechk : " + likechk);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(likechk, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
