package com.kh.jsp.search.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.search.model.service.SearchService;
import com.kh.jsp.styletip.model.service.StyleTipService;
import com.kh.jsp.styletip.model.vo.StyleTip;

/**
 * Servlet implementation class TipSearchServlet
 */
@WebServlet("/tipSearch.do")
public class TipSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StyleTip> list = null;
		
		SearchService ss = new SearchService();
		
		String searchValue = request.getParameter("search");
		
		System.out.println(searchValue);
		
		
		int listCount = ss.tipSearchCount(searchValue);
		
		System.out.println("전체 게시글 수 : " + listCount); // 계산에 사용
		
		
		list = ss.styleTipSearch(searchValue);
		
		System.out.println("서블릿 확인");

		
		System.out.println(list);
		
		String page = "";
		
		for(StyleTip i : list) {
			String mainImg = i.getTcontent();
			
			Pattern p = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
			Matcher m = p.matcher(mainImg);
			
			String imgTag = null;
			if(m.find()){ // 이미지 태그를 찾았다면,,
			    imgTag = m.group(0); // 글 내용 중에 첫번째 이미지 태그를 뽑아옴.
			}
			
			i.setImgTag(imgTag);
			
		}
		
		if(list != null) {
			page = "views/search/tipSearchView.jsp";
			request.setAttribute("list", list);
			
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 목록 불러오는 중 에러 발생");
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
