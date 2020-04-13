package com.kh.jsp.talk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.talk.model.service.TalkService;
import com.kh.jsp.talk.model.vo.Talk;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class DeleteTalkServlet
 */
@WebServlet("/delete.ta")
public class DeleteTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				int bno = Integer.parseInt(request.getParameter("bno"));
				
				TalkService ts = new TalkService();
				
				Talk t = ts.updateView(bno);
				
				int result = ts.deleteTalk(bno);

				
				if(result > 0) {
					
					response.sendRedirect("selectList.ta");
					
				} else {
					
					request.setAttribute("msg", "게시글 삭제 실패!");
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
