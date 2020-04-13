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
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>

</head>
<style>

.Xcontent {
    min-height: calc(100vh - 20px);
}

body {
	margin: 0;
	width: 100%;
	height: 100vh;
	background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F) center fixed;
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}

@keyframes gradientBG {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

#content {
	height: 400px;
	resize: none;
}

.form-group {
	margin-top: 50px;
	margin-left: 10%; 
	margin-right: 10%; 
}

#submit {
	width: 100px;
	padding: inherit !important;
}

#imgArea {
	display: inline-flex;
}

</style>
	<%@ include file="../common/headerUtil.jsp"%>

<body>


	<br /><br /><br /><br /><br />

	<%@ include file="../common/header.jsp"%>
	<div align="center">
		<div class="form-group">
			
			<form role="form" action="${pageContext.request.contextPath }/insert.ta"
				method="post">
				
				<input type="hidden" id="userNo" name="userNo" value="${member.userNo}" />
				<input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력하세요" /> &nbsp;
 				<textarea id="content" name="content" class="form-control" placeholder="내용을 입력하세요"></textarea>
				

				<br /><br />

				<div align="center">
					<input type="submit" value="작성완료" class="form-control" id="submit"/>
				</div>

			</form>
			
		</div>
	</div>

	<br /><br /><br /><br /><br />
	<br /><br /><br /><br /><br /><br /><br />



	<%@ include file="../common/footer.jsp"%>
	<%@ include file="../common/footerUtil.jsp"%>



</body>
</html>