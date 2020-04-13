package com.kh.jsp.eventboard.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.eventboard.model.service.EventService;



/**
 * Servlet implementation class UpdateThumbnailViewServlet
 */
@WebServlet("/tUpView.ttn")
public class UpdateEventViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEventViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		HashMap<String, Object> hmap = new EventService().updateView(bno);
		
		String page="";
		
		if(hmap !=null) {
			page="views/eventboard/eventUpdateView.jsp";
			request.setAttribute("eventboard", hmap.get("eventboard"));
			request.setAttribute("fileList", hmap.get("attachment"));
			System.out.println(hmap.get("eventboard")+"나는");
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 수정 화면 오류");
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
