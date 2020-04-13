package com.kh.jsp.Qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.Qna.model.service.QnAService;
import com.kh.jsp.Qna.model.vo.Qna;
import com.kh.jsp.qnaComment.model.service.CommentService;
import com.kh.jsp.qnaComment.model.vo.QnaComment;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager.Limit;

/**
 * Servlet implementation class SelectOneQnAServlet
 */
@WebServlet("/selectOne.qn")
public class SelectOneQnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneQnAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		Qna q = new QnAService().selectOne(qno);
		System.out.println("q 내용 확인 ; "+q);
		ArrayList<QnaComment> clist = new CommentService().selectList(qno);
		
		String page = "";
		
		if(q != null) {
			page = "views/qna/qnaDetail.jsp"; //이동경로 지정해줘야함
			request.setAttribute("qna", q);
			request.setAttribute("clist", clist);
		
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 에러");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
