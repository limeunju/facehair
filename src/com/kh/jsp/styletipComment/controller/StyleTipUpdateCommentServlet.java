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
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/updateco.st")
public class StyleTipUpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StyleTipUpdateCommentServlet() {
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
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		StyleTipCommentService cs = new StyleTipCommentService();
		StyleTipComment bc = new StyleTipComment();

		bc.setCno(cno);
		bc.setBno(bno);
		bc.setCcontent(content);
		
		int result = cs.updateComment(bc);
		
		if(result > 0) {
			response.sendRedirect("selectOne.st?bno="+bno+"&userNo="+userNo);
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
