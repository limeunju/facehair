package com.kh.jsp.thumbnail.controller;

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
import com.kh.jsp.thumbnail.model.service.ThumbnailService;
import com.kh.jsp.thumbnail.model.vo.Attachment;
import com.kh.jsp.thumbnail.model.vo.Thumbnail;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertThumbnailServlet
 */
@WebServlet("/insert.tn")
public class InsertThumbnailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertThumbnailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThumbnailService ts = new ThumbnailService();
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "멀티파트 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		            // KB     MB     -
		int maxSize = 1024 * 1024 * 100; // 100MB
		
		String savePath = request.getServletContext()
				          .getRealPath("/resources/thumbnailFiles/");
		
		// 사용자가 저장하는 파일은 서버의 형식에 맞게
		// 이름을 변경하여 별도로 처리한다.
		// test.jpg --> kakaotalk_20191127_000000.jpg
		
		// DefaultFileRenamePolicy를 사용하면
		// test.jpg --> test1.jpg ---> test2.jpg
		
		// 이건 못참겠다, 우리가 직접 이름을 변경해보자!!!
		//----> MyRenamePolicy !!
		
		MultipartRequest mre = new MultipartRequest(
								request,
								savePath,
								maxSize,
								"UTF-8",
								new MyRenamePolicy()
						);
		
		// 다중파일 업로드 처리하기
		// 배열 -> 컬렉션
		// 실제 저장될 이름
		ArrayList<String> saveFiles = new ArrayList<>();
		
		// 원래 파일 이름
		ArrayList<String> originFiles = new ArrayList<>();
		
		// Iterator의 조상을 사용하여
		// 폼(사용자가)이 전송한 파일의 이름들을 불러온다. 
		Enumeration<String> files = mre.getFileNames();
		
		while(files.hasMoreElements()) {
			// 파일 이름을 통해 실제 파일을 저장하며 DB에 전달할
			// changeName / originName을 각각 꺼낸다.
			
			String name = files.nextElement();
			
			System.out.println("전달 받은 파일명 : " + name);
			
			saveFiles.add(mre.getFilesystemName(name));
			originFiles.add(mre.getOriginalFileName(name));			
		}
		
		// Thumbnail 객체 만들기
		Thumbnail t = new Thumbnail();
		

		t.setScontent(mre.getParameter("content"));
		t.setWriter(Integer.parseInt(mre.getParameter("userNo")));
		
		// Attachment(DB 테이블 말하는 겁니다.)
		// 에 기록할 파일 리스트 생성하기
		
		ArrayList<Attachment> list = new ArrayList<>();
		
		for(int i = originFiles.size() -1; i > -1 ; i--) {
			// 역순으로 들어왔던 파일 재정렬하기
			Attachment at = new Attachment();
			
			at.setFilePath(savePath);
			at.setOriginName(originFiles.get(i));
			at.setChangeName(saveFiles.get(i));
			
			System.out.println("at 확인 : " + at);
			list.add(at);
		}
		
		// 작성한 내용을 service로 보내고 결과 받기
		int result = ts.insertThumbnail(t, list);
		
		if(result > 0 && originFiles.size() > 0 ) {
			response.sendRedirect("selectList.tn");
		} else {
			request.setAttribute("msg", "게시글 작성 실패!");
			
			// 실패했다면 등록할 예정이었던 파일 삭제하기
			for(int i = 0; i < originFiles.size(); i++) {
				File f = new File(savePath + saveFiles.get(i)); 
				
				System.out.println("파일 삭제 확인 : " + f.delete());
			}
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
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
