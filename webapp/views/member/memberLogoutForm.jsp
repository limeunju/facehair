<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 Page</title>
<link rel="shortcut icon" href="${ pageContext.request.contextPath }/resources/images/logo/favicon-16x16.png" type="image/x-icon" />
<link rel="icon" href="${ pageContext.request.contextPath }/resources/images/logo/favicon-16x16.png" type="image/x-icon" />
</head>
<body>
	<h1>로그인 상태 / 로그아웃 확인 임시 Page</h1>

	<hr />

	<c:if test="${ empty member }">
		<h3>로그인 X</h3>
	</c:if>

	<c:if test="${ !empty member }">
		<div id="userInfo">
			<h3>로그인 O</h3>
			<label>${ member.userName }님의 방문을 환영합니다.</label>
			<div>
				<!-- <div id="logoutBtn" onclick='logout()'>로그아웃</div> -->
				<button type="button" onclick="logout();">로그아웃</button>
			</div>
		</div>
	</c:if>

	<script>
		function logout() {
			location.href = "${ pageContext.request.contextPath }/logout.me";
		}
	</script>


</body>
</html>