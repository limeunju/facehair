package com.kh.jsp.styletip.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.common.MyRenamePolicy;
import com.kh.jsp.styletip.model.service.StyleTipService;
import com.google.gson.Gson;

import org.json.simple.JSONObject;
import com.oreilly.servlet.MultipartRequest;



/**
 * Servlet implementation class InsertTnlServlet
 */
@WebServlet("/insert.stsn")
public class SummernoteImgViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummernoteImgViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "멀티파트 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		} 
		
		int maxSize = 1024 * 1024 * 10;
		String savePath = request.getServletContext().getRealPath("/resources/styleTipFiles/");
		
		MultipartRequest mr = new MultipartRequest(
													request, 
													savePath,
													maxSize,
													"UTF-8",
													new MyRenamePolicy());
		
		
		// Iterator의 조상을 사용하여 form(사용자)가 전송한 파일의 이름들을 불러온다.
		Enumeration<String> files = mr.getFileNames(); 
		
		JSONObject jobj = new JSONObject();
		
		String uploadPath="";
		
		// 각 파일의 정보를 가져와서 DB에 저장할 내용을 추출한다.
		String name = files.nextElement();
		String fileName = mr.getFilesystemName(name);
		
		String serverPath = "http://192.168.20.148:8088/facehair/resources/styleTipFiles/"; // http://localhost:8088를 192.168.20.148로 바꿔야함
		
		System.out.println(serverPath);
		
		uploadPath = serverPath + fileName;
		
		jobj.put("url", uploadPath);
		
		response.setContentType("text/html; application/json; charset=UTF-8");
		response.getWriter().print(uploadPath);
		
		// new Gson().toJson(uploadPath, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
