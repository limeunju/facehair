package com.kh.jsp.qnaComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.qnaComment.model.service.CommentService;
import com.kh.jsp.qnaComment.model.vo.QnaComment;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/insert.qco")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String qcontent = request.getParameter("qcontent");
		int qno = Integer.parseInt(request.getParameter("qno"));
		int qwriter = Integer.parseInt(request.getParameter("qwriter"));
		
		QnaComment qco = new QnaComment();
		
		qco.setQcwriter(qwriter);
		qco.setQno(qno);
		qco.setQccontent(qcontent);
		
		int result = new CommentService().insertComment(qco);
		
		if(result > 0) {
			response.sendRedirect("selectOne.qn?qno="+qno);
		} else {
			request.setAttribute("msg", "댓글 작성 실패");
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
