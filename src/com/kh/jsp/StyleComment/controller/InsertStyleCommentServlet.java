package com.kh.jsp.StyleComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.StyleComment.model.service.StyleCommentService;
import com.kh.jsp.StyleComment.model.vo.StyleComment;

/**
 * Servlet implementation class InsertTalkCommentServlet
 */
@WebServlet("/insert.co")
public class InsertStyleCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStyleCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cwriter = Integer.parseInt(request.getParameter("writer"));
		String ccontent = request.getParameter("replyContent");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		StyleComment sco = new StyleComment();
		
		
		sco.setBno(bno);
		sco.setCwriter(cwriter);
		sco.setCcontent(ccontent);
		
		System.out.println(sco);
		
		int result = new StyleCommentService().insertComment(sco);
		
		if(result > 0) {
			response.sendRedirect("selectOne.tn?bno="+bno+"&userNo="+ cwriter);
		} else {
			request.setAttribute("msg", "댓글 작성 실패!!");
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
