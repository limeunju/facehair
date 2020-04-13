package com.kh.jsp.eventboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

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
 * Servlet implementation class UpdateEventServlet
 */
@WebServlet("/update.ttn")
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "멀티파트로 보내주숑");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			   .forward(request, response);
	}
	
	EventService ts = new EventService();
	int maxSize = 1024 * 1024 * 10;
	
	String savePath = request.getServletContext()
			          .getResource("/resources/eventFiles/").getPath();
	
	MultipartRequest mre = new MultipartRequest(
								request,
								savePath,
								maxSize,
								"UTF-8",
								new MyRenamePolicy()
							);
	
	int bno = Integer.parseInt(mre.getParameter("bno"));
	
	HashMap<String, Object> originThumb = ts.selectOne(bno);
	
	ArrayList<Attachment> list= null;
	
	ArrayList<String> saveFiles = new ArrayList<>();
	ArrayList<String> originFiles = new ArrayList<>();
	
	// form 으로 전달된 다중 파일 업로드
	Enumeration<String> files = mre.getFileNames();
	
	while(files.hasMoreElements()) {
		String name = files.nextElement();
		
		saveFiles.add(mre.getFilesystemName(name));
		originFiles.add(mre.getOriginalFileName(name));
	}
	
	 Eventboard e = (Eventboard) originThumb.get("eventboard");
	
	e.setEtitle(mre.getParameter("title"));
	e.setEcontent(mre.getParameter("content"));
	
	list = (ArrayList<Attachment>)originThumb.get("attachment");
	
	System.out.println(list);
	
	for(int i = originFiles.size()-1; i > -1; i--) {
		int j = originFiles.size() - i - 1;
		
		if(originFiles.get(i) !=null) {
			new File(savePath+list.get(j).getChangeName()).delete();
			
			list.get(j).setFilePath(savePath);
			list.get(j).setChangeName(saveFiles.get(i));
			list.get(j).setOriginName(originFiles.get(i));
			
			
		}
	}
	
	
	int result = ts.updateEventboard(e, list);
	
	if(result>0) {
		response.sendRedirect("ListEventboard.do");
	}else {
		request.setAttribute("msg", "파일 전송 및 수정 실패");
		
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
