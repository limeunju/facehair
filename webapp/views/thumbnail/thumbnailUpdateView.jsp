<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 게시글 수정 페이지</title>

<style>
	body {
    font-family: "Open Sans", Arial, sans-serif;
    min-height: 100vh;
    background-color: #fafafa;
    color: #262626;
    padding-bottom: 3rem;}
    
	.outer {
		width:1000px;
		height:auto;
		background:white;
		color:black;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
		box-shadow : 0px 0 30px #ccc;
	}
	table {
		border:1px solid white;
	}
	.insertArea {
		width:800px;
		height:auto;
		margin-left:auto;
		margin-right:auto;
	}
	.btnArea {
		width:400px;
		margin-left:auto;
		margin-right:auto;
	}
	#titleImgArea {
		width: 150px;
		height:150px;
		text-align:center;
		display:table-cell;
		vertical-align:middle;
	}
	#titleImgArea:hover, #contentImgArea1:hover, 
	#contentImgArea2:hover, #contentImgArea3:hover {
		cursor:pointer;
	}
	#contentImgArea1, #contentImgArea2, #contentImgArea3 {
		width:150px;
		height:150px;
		border:2px dashed darkgray;
		text-align:center;
		display:table-cell;
		vertical-align:middle;
	}
	[id*=content] > img {
		height : 150px;
	}
		button {
	border-collapse: collapse;
	border:0;
	border-radius: 5px;
	padding:5px;
	margin:5px;
	display: inline-block;
	border:1px solid #CCC;
	background-color: transparent;
	cursor: pointer;
}
</style>
<script src ="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	
	<section class="outer">
		<br><br><br><br><br>
		
		<c:url var="tUpFolder" value="resources/thumbnailFiles/"/>
		<form action="${pageContext.request.contextPath }/update.tn"
		      method="post" enctype="multipart/form-data">
			<div class="updateArea">
				<input type="hidden" name="bno" value="${thumbnail.bno}" />
				<table align="center">
					<tr>
						<td>대표 이미지</td>
						<td colspan="3">
							<div id="titleImgArea">
								<img id="titleImg" width="150" height="150" 
								     src="${tUpFolder}${fileList[0].changeName}">
							</div>
						</td>
					</tr>
					
					<tr>
						<td width="100px">사진 메모</td>
						<td colspan="3">
							<textarea name="content" rows="5" cols="50" style="resize:none;">${thumbnail.scontent}</textarea>
						</td>
					</tr>
				</table>
				<div id="fileArea">
					<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="LoadImg(this,1)">
				</div>
			</div>
			<div class="btnArea" align="center">
				<button type="submit">작성완료</button>
				<button type="reset">작성취소</button>
			</div>
		</form>
		<script>
			// 사진을 추가하였을 때, 이미지 태그와 연동하여 바로 보이도록
			// '미리보기'기능 구현하기
			$(function(){
				$('#fileArea').hide();
				
				// $('#titleImgArea').on('click',function(){ });
				$('#titleImgArea').click(() => {
					$('#thumbnailImg1').click();
				});
				
				$('#contentImgArea1').click(() => {
					$('#thumbnailImg2').click();
				});
				
				$('#contentImgArea2').click(() => {
					$('#thumbnailImg3').click();
				});
				
				$('#contentImgArea3').click(() => {
					$('#thumbnailImg4').click();
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
						case 3: $('#contentImg2').attr('src', e.target.result);
							break;
						case 4: $('#contentImg3').attr('src', e.target.result);
							break;
						}
					}
					reader.readAsDataURL(value.files[0]);
				}
			}
		</script>
		
		<br><br><br><br>
	</section>
</body>
</html>




