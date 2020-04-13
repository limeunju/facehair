package com.kh.jsp.styletip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.jsp.styletip.model.service.StyleTipService;
import com.kh.jsp.styletip.model.vo.StyleTip;

/**
 * Servlet implementation class InfiniteScrollServlet
 */
@WebServlet("/scroll.st")
public class InfiniteScrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfiniteScrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StyleTip> list = null;
		StyleTipService sts = new StyleTipService();
		
		int startPage;
		int currentPage;
		int limit;
		
		currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		limit = 10;	
		
		int listCount = sts.getListCount();
		
		System.out.println("전체 게시글 수 : " + listCount); 
		
		
		list = sts.selectList(currentPage, limit); 
		
		System.out.println(list);
		
		for(StyleTip i : list) {
			String mainImg = i.getTcontent();
			Pattern p = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
			Matcher m = p.matcher(mainImg);
			
			String imgTag = null;
			if(m.find()){ 
			    imgTag = m.group(0); 
			}
			
			i.setImgTag(imgTag);
			
			
		}
		
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
