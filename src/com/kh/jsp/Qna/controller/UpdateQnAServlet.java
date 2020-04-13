package com.kh.jsp.Qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.Qna.model.service.QnAService;
import com.kh.jsp.Qna.model.vo.Qna;

/**
 * Servlet implementation class UpdateQnAServlet
 */
@WebServlet("/update.qn")
public class UpdateQnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQnAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QnAService qs = new QnAService();
		Qna q = new Qna();
		int qno = Integer.parseInt(request.getParameter("bno"));
		
		String qTitle = request.getParameter("title");
		String qContent = request.getParameter("content");
		
		q.setQno(qno);
		q.setQtitle(qTitle);
		q.setQcontent(qContent);
		
		int result = qs.updateQnA(q);
		
		if(result > 0) {
			
			response.sendRedirect("selectList.qn");
		} else {
			
			request.setAttribute("msg", "게시글 수정중 오류 발생");
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
