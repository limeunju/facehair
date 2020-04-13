<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<c:import url="../common/headerUtil.jsp"/>
<style>
body {
	margin: 0;
	width: 100%;
	height: 100vh;
	background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F) center fixed !important;
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
.swiper-slide {

    text-align: center !important;
}

</style>


  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
  
  <script src="https://unpkg.com/swiper/js/swiper.js"></script>
  <script src="https://unpkg.com/swiper/js/swiper.min.js"></script>

  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/card.css">



  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.slim.min.js"></script>


<title>이벤트 게시글 수정 페이지</title>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<c:import url="../common/header.jsp"/>



<script src="${pageContext.request.contextPath }/resources/js/card.js"></script>

<!-- card  end -->


<section class="outer">

		<br><br /><br /><br />
		<h2 align="center">이벤트 게시글 수정</h2>
		<c:url var="tUpFile" value="resources/eventFiles/"/>
		<c:set var="eventNo" value="${eventboard.bno}"/>
		<form action="${pageContext.request.contextPath }/update.ttn"
		      method="post" enctype="multipart/form-data">
			<div class="updateArea" align="center">
				<input type="hidden" name="bno" value="${eventboard.bno}" />
			  <div  >
				<br><br /><br /><br />
		     			<div class="form-block">글 제목 :
     				  <input class="form-element" type="text" name="title" value="${eventboard.etitle}">
       					 </div>
       					 <br /><br />
				
						
								<p style="font-size: 20px">대표 사진</p>
							<div id="eventImgArea" >
								<img id="titleImg" width="400" height="150" style="background: #e8ebed;" src="${tUpFile}${fileList[1].changeName}">
								
							</div>
					
						<br />
								<p style="font-size: 20px">내용 사진</p>
							<div id="eventImgArea1">
								<img id="contentImg1" width="400" height="150" style="background: #e8ebed;" src="${tUpFile}${fileList[0].changeName}">
							</div>
						<br />
						
       						 <textarea name="content" class="form-element" rows="3">${eventboard.econtent}</textarea>
	
				</div>
				
				<div id="fileArea">
					<input type="file" id="eventImg1" name="eventImg1" onchange="LoadImg(this,1)"/>
					<input type="file" id="eventImg2" name="eventImg2" onchange="LoadImg(this,2)"/>
				</div>
			</div>
			
			<div class="btnArea button" style="align:center">
				<button  type="submit">작성완료</button>
				<button  type="reset" 
				onclick="location.href='${pageContext.request.contextPath}/ListEventboard.do'" >작성취소</button>
				
			</div>
		</form>
		<script>
			// 사진을 추가하였을 때, 이미지 태그와 연동하여 바로 보이도록
			// '미리보기'기능 구현하기
			$(function(){
				$('#fileArea').hide();
				
				// $('#titleImgArea').on('click',function(){ });
				$('#eventImgArea').click(() => {
					$('#eventImg1').click();
				});
				$('#eventImgArea1').click(() => {
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
					<br><br><br><br>
			</section>
			
<c:import url="../common/footer.jsp"/>
<c:import url="../common/footerUtil.jsp"/>

</body>
</html>