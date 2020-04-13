package com.kh.jsp.eventboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.common.MyRenamePolicy;
import com.kh.jsp.eventboard.model.service.EventService;
import com.kh.jsp.eventboard.model.vo.Attachment;
import com.kh.jsp.eventboard.model.vo.Eventboard;
import com.oreilly.servlet.MultipartRequest;



/**
 * Servlet implementation class InsertEventBoard
 */
@WebServlet("/InsertEventBoard")
public class InsertEventBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEventBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventService es = new EventService();
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "멀티파일 전송이아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
		int maxSize = 1024 * 1024 * 10;
		
		String savePath = request.getServletContext().getRealPath("/resources/eventFiles/");
		
		MultipartRequest mre = new MultipartRequest(
				request, 
				savePath,
				maxSize,
				"UTF-8",
				new MyRenamePolicy()
				);
		ArrayList<String> saveFiles = new ArrayList<>();
		ArrayList<String> originFiles = new ArrayList<>();
		
		Enumeration<String> files = mre.getFileNames();
		
		while(files.hasMoreElements()) {
			
			String name = files.nextElement();
			
			System.out.println("전달 받은 파일명 : "+ name);
			
			saveFiles.add(mre.getFilesystemName(name));
			originFiles.add(mre.getOriginalFileName(name));
			
		}
		
		Eventboard eb = new Eventboard();
		
		eb.setEtitle(mre.getParameter("title"));
		eb.setEcontent(mre.getParameter("content"));

	
		
		ArrayList<Attachment> list = new ArrayList<>();
		for(int i = originFiles.size() -1; i>-1; i--) {
			Attachment at = new Attachment();
			
			at.setFilePath(savePath);
			at.setOriginName(originFiles.get(i));
			at.setChangeName(saveFiles.get(i));
			
			System.out.println("at 확인 : " + at );
			list.add(at);
		}
		
		
		
		int result = new EventService().insertEventboard(eb, list);
		
		
		
		if(result==2) {
			
			
			response.sendRedirect("ListEventboard.do");
			
			
		}else {
			request.setAttribute("msg", "게시글작성 오류");
			for(int i = 0; i<originFiles.size();i++){
				File f = new File(savePath+saveFiles.get(i));
				
				System.out.println("파일삭제 확인 : "+f.delete());
			}
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
