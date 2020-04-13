package com.kh.jsp.thumbnail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.thumbnail.model.service.ThumbnailService;

/**
 * Servlet implementation class DeleteThumbnailServlet
 */
@WebServlet("/delete.tn")
public class DeleteThumbnailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteThumbnailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		int result = new ThumbnailService().deleteThumbnail(bno);
		
		if(result > 0) {
			response.sendRedirect("selectList.tn");
			
		} else {
			request.setAttribute("msg", "게시글 삭제 중 에러 발생");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);			
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
