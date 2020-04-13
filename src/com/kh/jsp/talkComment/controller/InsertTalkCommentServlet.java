package com.kh.jsp.talkComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.talkComment.model.service.TalkCommentService;
import com.kh.jsp.talkComment.model.vo.TalkComment;

/**
 * Servlet implementation class InsertTalkCommentServlet
 */
@WebServlet("/insert.taco")
public class InsertTalkCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTalkCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cwriter = Integer.parseInt(request.getParameter("userNo"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		String ccontent = request.getParameter("replyContent");
		
		TalkComment tco = new TalkComment(cwriter, bno, ccontent);
		
		int result = new TalkCommentService().insertComment(tco);
		
		if(result > 0) {
			response.sendRedirect("selectOne.ta?bno=" + bno);
		} else {
			request.setAttribute("msg", "댓글 작성 실패!");
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
