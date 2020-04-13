package com.kh.jsp.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.member.model.service.MemberService;
import com.kh.jsp.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원이 기입한 정보 받아오기
		String userId = request.getParameter("joinId");
		String password = request.getParameter("JoinPwd");
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		
		Date dateOfBirth = null;
		
		System.out.println("생년월일 확인 : " + request.getParameter("dateOfBirth"));
		
		try {
			java.util.Date format = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
			
			System.out.println("format 값 : " +  format);
			
			dateOfBirth = new Date(format.getTime());
			
			System.out.println("dateOfBirth 값 : " +  dateOfBirth);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");

		// 회원 가입용 Member 확인하기
		Member m = new Member(userId, password, userName, email, dateOfBirth, gender, phone);

		System.out.println("받은 정보 확인 : " + m);

		// 회원 가입 서비스 실행!!
		int result = new MemberService().insertMember(m);

		if (result > 0) {
			System.out.println("회원 가입 성공!");
			
			// 성공하면 바로 메인 창으로 이동
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("회원 가입 실패!");
			
			// 실패하면 에러페이지로!
			request.setAttribute("msg", "회원 가입 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
