package com.kh.jsp.thumbnail.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.StyleComment.model.service.StyleCommentService;
import com.kh.jsp.StyleComment.model.vo.StyleComment;
import com.kh.jsp.thumbnail.model.service.ThumbnailService;
import com.kh.jsp.thumbnail.model.vo.Thumbnail;

/**
 * Servlet implementation class SelectOneThumbnailServlet
 */
@WebServlet("/selectOne.tn")
public class SelectOneThumbnailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneThumbnailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		HashMap<String, Object> t = new ThumbnailService().selectOne(bno);
		
		int likecount2 = new ThumbnailService().likeCount2(bno);
		int likechk2 = new ThumbnailService().likechk2(bno, userNo);
		
		HashMap<String, Object> thumb = new ThumbnailService().selectOne(bno);
		
		
		// 댓글도 리스트로 가져오기
				ArrayList<StyleComment> clist
				   = new StyleCommentService().selectList(bno);
		
		String page="";
		
		if(thumb != null) {
			page = "views/thumbnail/thumbnailDetail.jsp";
			request.setAttribute("thumbnail", thumb.get("thumbnail"));
			request.setAttribute("fileList", thumb.get("attachment"));
			request.setAttribute("clist", clist); // 화면으로 보내줌
			request.setAttribute("likecount", likecount2);	
			request.setAttribute("likechk", likechk2);
			
		} else {
			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 에러 발생, ♡");
			
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
