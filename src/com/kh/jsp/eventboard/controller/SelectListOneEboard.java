package com.kh.jsp.eventboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.boardComment.model.service.CommentService;
import com.kh.jsp.boardComment.model.vo.BoardComment;
import com.kh.jsp.eventboard.model.service.EventService;
import com.kh.jsp.eventboard.model.vo.Eventboard;
import com.kh.jsp.member.model.vo.Member;

/**
 * Servlet implementation class SelectListOneEboard
 */
@WebServlet("/SelectOneEboard.do")
public class SelectListOneEboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectListOneEboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		HashMap<String, Object> ebs = new EventService().selectOne(bno);
		
		System.out.println("이벤트상세리스트 확인 : "+ebs);
		
		ArrayList<BoardComment> clist = new CommentService().selectList(bno);
		ArrayList<Member> mlist = new CommentService().mselectList(bno);
		ArrayList<Eventboard> toplist = new EventService().top5();
		
		String page = "";
		
		if(ebs != null) {
			page = "views/eventboard/eventboardListOne.jsp";
			request.setAttribute("eventboard", ebs.get("eventboard"));
			request.setAttribute("fileList", ebs.get("attachment"));
			request.setAttribute("member", ebs.get("member"));
			request.setAttribute("toplist", toplist);
			request.setAttribute("clist", clist);
			request.setAttribute("mlist", mlist);
			
			
			
		}else {
			page = "views/eventboard/eventboardListOne.jsp";
			request.setAttribute("msg", "이벤트 상세게시판 오류");
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
