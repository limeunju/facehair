package com.kh.jsp.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.notice.model.service.NoticeService;
import com.kh.jsp.notice.model.vo.NoticeBoard;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/update.no")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService ns = new NoticeService();
		NoticeBoard n = new NoticeBoard();
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("업데이트 서블릿 왔는지 확인" + bno);
	
	
		String nTitle = request.getParameter("title");
		String nContent = request.getParameter("content");
		
		n.setBno(bno);
		n.setnTitle(nTitle);
		n.setnContent(nContent);
		
		int result = ns.updateNotice(n);
		
		if(result > 0) {
			
			response.sendRedirect("selectList.no");
		
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
