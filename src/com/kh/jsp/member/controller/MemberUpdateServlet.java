package com.kh.jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.jsp.member.model.service.MemberService;
import com.kh.jsp.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/update.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("JoinPwd");
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		MemberService ms = new MemberService();
		
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member");
		
		System.out.println("기존 회원 정보 : " + session.getAttribute("member"));

		m.setPassword(password);
		m.setUserName(userName);
		m.setEmail(email);
		m.setGender(gender);
		m.setPhone(phone);
		
		System.out.println("수정 후 정보 : " + m);
		
		int result = ms.updateMember(m);
		
		if(result > 0) {
			System.out.println("회원 정보 수정 완료! : " + m);
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("회원 정보 수정 실패!");
			
			request.setAttribute("msg", "회원 정보 수정 중 에러가 발생했습니다.");
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
