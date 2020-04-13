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
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/update.qco")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qcno = Integer.parseInt(request.getParameter("qcno"));
		int qno = Integer.parseInt(request.getParameter("qno"));
		String qccontent = request.getParameter("qccontent");
		
		CommentService cs = new CommentService();
		QnaComment qco = new QnaComment();
		
		qco.setQcno(qcno);
		qco.setQno(qno);
		qco.setQccontent(qccontent);
		
		int result = cs.updateComment(qco);
		
		if(result > 0) {
			response.sendRedirect("selectOne.qn?qno="+qno);
			
		} else {
			request.setAttribute("msg", "댓글 수정 중 에러 발생");
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
