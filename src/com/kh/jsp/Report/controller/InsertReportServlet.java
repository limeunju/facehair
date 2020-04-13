package com.kh.jsp.Report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.Report.model.service.ReportService;
import com.kh.jsp.Report.model.vo.Report;

/**
 * Servlet implementation class InsertReportServlet
 */
@WebServlet("/insertReport.do")
public class InsertReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportService rs = new ReportService();

		Report r = new Report();
				
		r.setBno(Integer.parseInt(request.getParameter("bno")));
		r.setRepcon(request.getParameter("repcon"));
		
		int result = rs.insertReport(r);
		
		if(result > 0) {
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("신고글 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jps");
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
