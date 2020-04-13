<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<style>
body {
	margin: 0;
	width: 100%;
	height: 100vh;
	background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F) center fixed !important;
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}
.container{
    width : 100% !important;
    padding-right:  !important;
    padding-left: !important;
}
</style>
  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
  
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
  <script src="https://unpkg.com/swiper/js/swiper.js"></script>
  <script src="https://unpkg.com/swiper/js/swiper.min.js"></script>

  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/card.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/button.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/table.css">


<meta charset="UTF-8">
<title>이벤트 작성 페이지</title>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
<c:import url="../common/headerUtil.jsp"/>
</head>

<body background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F) center fixed !important;>
<c:import url="../common/header.jsp"/>



<!-- card  end -->


<br /><br /><br /><br /><br /><br /><br /><br /><br />
<br /><br /><br /><br /><br /><br /><br /><br /><br />
<div class="outer" style="flex: 10px;">
	
		
		<h2 align="center"></h2>
		<form action="${pageContext.request.contextPath }/InsertEventBoard"
		      method="post" enctype="multipart/form-data">
			<div class="insertArea" align="center">
				<input type="hidden" name="userId" value="${member.userId}" />
				
		
				<div  >
				
						<div class="form-block">
     				  <input class="form-element" type="text" placeholder="제목" name="title">
       					 </div>
				
					
								<p style="font-size: 20px">대표 사진</p>
							<div id="titleImgArea" >
								<img id="titleImg" width="400" height="150" style="background: #e8ebed;">
								
							</div>
					
						<br />
								<p style="font-size: 20px">내용 사진</p>
							<div id="contentImgArea1">
								<img id="contentImg1" width="400" height="150" style="background: #e8ebed;">
							</div>
						<br />
						
       						 <textarea name="content" class="form-element" rows="3" placeholder="내용"></textarea>
	
				</div>
					
			
				<br /><br />
				<div id="fileArea">
					<input type="file" id="eventImg1" name="eventImg1" onchange="LoadImg(this,1)">
					<input type="file" id="eventImg2" name="eventImg2" onchange="LoadImg(this,2)">
				</div>
			</div>
			<div class="btnArea" align="center">
				<button class="button" type="submit">작성완료</button>
				<button class="button" type="reset" >작성취소</button>
			</div>
		</form>
		<div align="right">
			<button class="button" onclick="location.href='${pageContext.request.contextPath}/ListEventboard.do'">뒤로가기</button>
		</div>
	
	</div>
	<br /><br />
	<script>
			// 사진을 추가하였을 때, 이미지 태그와 연동하여 바로 보이도록
			// '미리보기'기능 구현하기
			$(function(){
				$('#fileArea').hide();
				
				// $('#titleImgArea').on('click',function(){ });
				$('#titleImgArea').click(() => {
					$('#eventImg1').click();
				});
				$('#contentImgArea1').click(() => {
					$('#eventImg2').click();
				});
				
			
			});

			function LoadImg(value, num) {
				if(value.files && value.files[0]) {
					var reader = new FileReader();
					
					reader.onload = function(e){
						switch(num){
						case 1: $('#titleImg').attr('src', e.target.result);
							break;
				
						case 2: $('#contentImg1').attr('src', e.target.result);
						break;
						}
					}
					reader.readAsDataURL(value.files[0]);
				}
			}
		</script>
		
		

<c:import url="../common/footer.jsp"/>
<c:import url="../common/footerUtil.jsp"/>
		
</body>
</html>