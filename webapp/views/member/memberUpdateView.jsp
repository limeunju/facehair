<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.Xcontent {
	min-height: calc(100vh - 20px);
	background-color: #FEDDDF;
}

body {
	margin: 0;
}
</style>
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
<%@ include file="../common/headerUtil.jsp"%>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<div class="Xcontent">
	
	<br /><br /><br /><br /><br />

	<div align="center" style="margin: 10%;">
		<h1> <b style="font-size: 150px;">${member.userName }</b>님, 반갑습니다!</h1>
		
		<h3><a href="${ pageContext.request.contextPath }/views/member/memberUpdateForm.jsp"><i class="fas fa-cog" style="color: #ff666f">회원정보수정</i></a></h3>
	</div>


	</div>
	
	<%@ include file="../common/footer.jsp"%>
	<%@ include file="../common/footerUtil.jsp"%>
	
</body>
</html>