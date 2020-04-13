package com.kh.jsp.styletip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.styletipComment.model.service.StyleTipCommentService;
import com.kh.jsp.styletipComment.model.vo.StyleTipComment;
import com.kh.jsp.styletip.model.service.StyleTipService;
import com.kh.jsp.styletip.model.vo.StyleTip;


/**
 * Servlet implementation class SelectOneThumbnailServlet
 */
@WebServlet("/selectOne.st")
public class SelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		StyleTip st = new StyleTipService().selectOne(bno);
		int likecount = new StyleTipService().likeCount(bno);
		int likechk = new StyleTipService().likechk(bno, userNo);
		
		// 댓글도 리스트로 가져오기
		ArrayList<StyleTipComment> clist
		   = new StyleTipCommentService().selectList(bno);
		
		System.out.println(clist);
		System.out.println("likechk: " + likechk);
		System.out.println("likecount: " + likecount);
		System.out.println("bno: " + bno);
		String page = "";
		
		if(st != null) {
			page = "views/styletip/styleTipDetail.jsp";
			request.setAttribute("StyleTip", st);
			request.setAttribute("clist", clist);
			request.setAttribute("likecount", likecount);	
			request.setAttribute("likechk", likechk);
			
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 에러!!");
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
