<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../common/commonUtil.jsp"/>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../../resources/css/bootstrap.min.css" type="text/css" id="bootstrap-css"> 
<style>
	.outer {
		align: center;
		background-color:#FEDDDF;
	}
	.likeBtn {
		position: absolute;
		position: fixed;
		right: 30px; 
		bottom: 30px;
	}
	.btn-circle.btn-lg {
	  width: 50px;
	  height: 50px;
	  padding: 12px 14px;
	  font-size: 18px;
	  line-height: 1.33;
	  border-radius: 25px;
	  background-color: #ff666f;
	  border-color: #ff666f;
	  cursor: pointer;
	}
</style>
<c:import url="../common/headerUtil.jsp"/>
</head>
<body>
	<c:import url="../common/header.jsp"/>
	
	<section class="outer" align="center">
	
		<br /><br /><br /><br /><br />
		<br /><br /><br /><br /><br />
		<br /><br /><br /><br /><br />
		<br /><br /><br /><br /><br />
		<br /><br /><br /><br /><br />
		<br /><br />
		
		<div class="likeBtn">
			<%-- <c:if test="${member.mlevel eq 1 }">  --%>
			<button type="button" class="btn btn-primary btn-circle btn-lg" onclick="goList();">
				<i class="glyphicon glyphicon-heart"></i>
			</button> 
			<%-- </c:if> --%>
		</div>
		
		<br /><br /><br /><br /><br />
		<br /><br /><br /><br /><br />
		<br /><br /><br /><br /><br />
		<br /><br /><br /><br /><br />
		
	</section>
</body>
</html>