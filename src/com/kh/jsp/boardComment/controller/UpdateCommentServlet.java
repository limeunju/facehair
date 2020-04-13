package com.kh.jsp.boardComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.boardComment.model.service.CommentService;
import com.kh.jsp.boardComment.model.vo.BoardComment;

/**
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/Update.cco")
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
		int cno = Integer.parseInt(request.getParameter("cno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
	
		String content = request.getParameter("ccontent");
		
		CommentService cs = new CommentService();
		BoardComment bco = new BoardComment();
	
		bco.setCno(cno);
		bco.setBno(bno);
		bco.setCcontent(content);
		
		int result = cs.updateComment(bco);
		
		if(result>0) {
			response.sendRedirect("SelectOneEboard.do?bno="+bno);
			
		}else {
			request.setAttribute("msg", "댓글 수정중 에러");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
			
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
