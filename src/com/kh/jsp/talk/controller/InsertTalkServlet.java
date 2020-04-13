package com.kh.jsp.talk.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.talk.model.service.TalkService;
import com.kh.jsp.talk.model.vo.Talk;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertTalkServlet
 */
@WebServlet("/insert.ta")
public class InsertTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int writer = Integer.parseInt(request.getParameter("userNo"));
		String tTitle = request.getParameter("title");
		String tContent = request.getParameter("content");

		System.out.println("writer 값 확인 : " + writer);
		System.out.println("tTitle 값 확인 : " + tTitle);
		System.out.println("tContent 값 확인 : " + tContent);
		
		Talk t =  new  Talk(writer, tTitle, tContent);
		
		int result = new TalkService().insertTalk(t);
		
		System.out.println("result 값 확인 : " + result);
		
		if(result == 2) {
			// response.sendRedirect("selectList.bo");
			response.sendRedirect("selectList.ta");
			
		} else {
			request.setAttribute("msg", "게시글 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
