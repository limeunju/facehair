package com.kh.jsp.talk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.talk.model.service.TalkService;
import com.kh.jsp.talk.model.vo.Talk;
import com.kh.jsp.talkComment.model.service.TalkCommentService;
import com.kh.jsp.talkComment.model.vo.TalkComment;


/**
 * Servlet implementation class SelectOneTalkServlet
 */
@WebServlet("/selectOne.ta")
public class SelectOneTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Talk t = new TalkService().selectOne(bno);
		
		// 댓글도 리스트로 가져오기
		ArrayList<TalkComment> clist = new TalkCommentService().selectList(bno);
		
		
		String page = "";
		
		if(t != null) {
			page = "views/talk/talkDetail.jsp";
			request.setAttribute("talk", t);
			request.setAttribute("clist", clist);
			
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 에러!!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
