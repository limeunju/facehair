package com.kh.jsp.styletip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.styletip.model.service.StyleTipService;
import com.kh.jsp.styletip.model.vo.StyleTip;

/**
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/update.st")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		String filter = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("editordata");
		
		StyleTipService sts = new StyleTipService();
		StyleTip st = new StyleTip();

		st.setBno(bno);
		st.setTfilter(filter);
		st.setTtitle(title);
		st.setTcontent(content);
		
		System.out.println(st);
		System.out.println(bno);
		
		int result = sts.updateStyleTip(st);
		
		if(result > 0) {
			response.sendRedirect("selectOne.st?bno="+bno+"&userNo="+userNo);
		} else {
			request.setAttribute("msg", "댓글 수정 중 에러 발생");
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
