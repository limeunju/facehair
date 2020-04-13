<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
<style>
	.btn-outline-light {
		background : gray;
	}
</style>
</head>
<body style="background: pink;">
 <%@ include file="../common/header.jsp" %>
 <%@ include file="../common/headerUtil.jsp" %>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
 <div align="center">
 <form method="post" id="searchForm">
 <select name="searchMenu" id="searchMenu">
 <option value="Talk">Talk</option>
 <option value="StyleTip">StyleTip</option>
 <option value="Event">Event</option>
 <option value="notice">Notice</option>
 </select>
 <input type="text" placeholder="검색어를 입력해주세요." name="search"/>
 <button type="button" class="btn btn-outline-light" 
                onclick="searchGo();">검색하기
         </button>
</div>
 <script>
 	function searchGo(){
 		
 		var searchMenu = document.getElementById("searchMenu");
 		
 		console.log(searchMenu);
 		
 		switch(searchMenu.value){
 		case 'Talk' :
				$('#searchForm').attr("action","${pageContext.request.contextPath}/talkSearch.do");

 			break;
 		case 'StyleTip' :
				$('#searchForm').attr("action","${pageContext.request.contextPath}/tipSearch.do");

 			break;
 			
 		case 'Event' :
				$('#searchForm').attr("action","${pageContext.request.contextPath}/eventSearch.do");

 			break;
 		
 		case 'notice' :
 				$('#searchForm').attr("action","${pageContext.request.contextPath}/noticeSearch.do");
 			break;
 		}
 		
 		$('#searchForm').submit();
 	}
 </script>
</form>


 <%@ include file="../common/footer.jsp" %>
 <%@ include file="../common/footerUtil.jsp" %>
</body>
</html>