package com.kh.jsp.talk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.talk.model.service.TalkService;
import com.kh.jsp.talk.model.vo.Talk;

/**
 * Servlet implementation class UpdateViewTalkServlet
 */
@WebServlet("/tUpView.ta")
public class UpdateViewTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateViewTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Talk t = new TalkService().updateView(bno);
		
		String page = "";
		if(t != null) {
			
			page = "views/talk/talkUpdateForm.jsp";
			request.setAttribute("talk", t);
		} else {
			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정 화면 조회 실패!");			
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
