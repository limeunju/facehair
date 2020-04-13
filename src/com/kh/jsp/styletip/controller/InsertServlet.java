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
 * Servlet implementation class StyleTipInsertServlet
 */
@WebServlet("/insert.st")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StyleTipService sts = new StyleTipService();
		
		// 객체 생성 후 DB에 전달할 VO설정
		StyleTip st = new StyleTip();
		
		st.setTfilter(request.getParameter("category"));
		st.setTtitle(request.getParameter("title"));
		st.setTcontent(request.getParameter("editordata"));
		
		System.out.println(st.getTcontent());
		
		// service로 내용 전달
		int result = sts.insertStyleTip(st);
		
		if(result > 0) {
			response.sendRedirect("selectList.st");
		} else {
			request.setAttribute("msg", "스타일팁 글 작성 에러!");
			System.out.println("error!!!!!");
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
