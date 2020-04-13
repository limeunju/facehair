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
			
			<form id="updateForm" role="form" method="post">
				
				<input type="hidden" id="bno" name="bno" value="${talk.bno}" />
				<input type="text" id="title" name="title" class="form-control" value="${ talk.tTitle }"/> &nbsp;
 				<textarea id="content" name="content" class="form-control">${ talk.tContent }</textarea>
				

				<br /><br />

				<div align="center">
					<button onclick="completeUpdate();" class="btn btn-success"><i class="fas fa-pencil-square-o"> </i> 수정</button>
					<button onclick="backList();" class="btn btn-secondary"><i class="fas fa-undo"></i> 돌아가기</button>
				</div>

			</form>
			
		</div>
	</div>
	
	<script>
		function completeUpdate() {
    		$('#updateForm').attr("action", "${pageContext.request.contextPath}/update.ta");
		}
		
		function backList() {
    		$('#updateForm').attr("action", "${pageContext.request.contextPath}/selectList.ta");
			
		}
	</script>

	<br /><br /><br /><br /><br />
	<br /><br /><br /><br /><br /><br /><br />



	<%@ include file="../common/footer.jsp"%>
	<%@ include file="../common/footerUtil.jsp"%>



</body>
</html>