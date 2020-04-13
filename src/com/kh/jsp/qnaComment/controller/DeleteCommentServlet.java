package com.kh.jsp.qnaComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.qnaComment.model.service.CommentService;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/delete.qco")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qcno = Integer.parseInt(request.getParameter("qcno"));
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		System.out.println(qcno);
		System.out.println(qno);
		
		CommentService cs = new CommentService();
		
		int result = cs.deleteComment(qcno);
		
		if(result > 0) {
			response.sendRedirect("selectOne.qn?qno="+qno);
			
		} else {
			request.setAttribute("msg", "댓글 삭제 중 에러 발생");
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
