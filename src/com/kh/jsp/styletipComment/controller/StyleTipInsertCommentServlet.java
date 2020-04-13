package com.kh.jsp.styletipComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.styletipComment.model.service.StyleTipCommentService;
import com.kh.jsp.styletipComment.model.vo.StyleTipComment;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/insertco.st")
public class StyleTipInsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StyleTipInsertCommentServlet() {
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
		
		StyleTipComment bco = new StyleTipComment();
		
		bco.setBno(bno);
		bco.setCwriter(cwriter);
		bco.setCcontent(ccontent);
		
		int result = new StyleTipCommentService().insertComment(bco);
		
		
		if(result > 0) {
			response.sendRedirect("selectOne.st?bno="+bno+"&userNo="+cwriter);
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
