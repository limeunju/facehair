package com.kh.jsp.boardComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.boardComment.model.service.CommentService;
import com.kh.jsp.boardComment.model.vo.BoardComment;
import com.kh.jsp.eventboard.model.vo.Eventboard;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/insert.cco")
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
		
		String ccontent = request.getParameter("replyContent");
		
		int cwriter = Integer.parseInt(request.getParameter("cwriter"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardComment bco = new BoardComment();
		Eventboard eb = new Eventboard();
		
		bco.setBno(bno);		
		bco.setCwriter(cwriter);
		bco.setCcontent(ccontent);
	
		int result = new CommentService().insertComment(bco);
		
		if(result>0) {
			response.sendRedirect("SelectOneEboard.do?bno="+bno);
		}else {
			request.setAttribute("msg", "댓글작성 실패");
			request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
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
