<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	margin: 0;
	width: 100%;
	height: 100vh;
	background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F)
		center fixed !important;
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}

@
keyframes gradientBG { 0% {
	background-position: 0% 50%;
}

50%
{
background-position
:
 
100%
50%;
}
100%
{
background-position
:
 
0%
50%;
}
}
.swiper-slide {
	text-align: center !important;
}
</style>
<!-- 댓글 css -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/assets/css/comment.css">
<!-- 댓글 css끝 -->

<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/css/swiper.min.css">

<script src="https://unpkg.com/swiper/js/swiper.js"></script>
<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/assets/css/card.css">



<meta charset="UTF-8">
<title>이벤트글 상세보기</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

<c:import url="../common/headerUtil.jsp" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/assets/css/button.css" />
	
</head>


<body>

	<c:import url="../common/header.jsp" />

	<!-- card -->

	<section class="swiper-container loading"
		style="margin-top: 100px !important; width: 300px; hegiht: 200px; text-align: center">
		<div class="swiper-wrapper" id="swipe">
			<c:forEach items="${ toplist }" var="top">
				<div class="swiper-slide"
					style="background-image:url('${pageContext.request.contextPath}/resources/eventFiles/${top.bfile}"')">
					<img
						src="${pageContext.request.contextPath}/resources/eventFiles/${top.bfile}"
						class="entity-img" />
					<div class="content">
						<p class="title" data-swiper-parallax="-30%"
							data-swiper-parallax-scale=".7"></p>
						<span class="caption" data-swiper-parallax="-20%"></span>
					</div>
				</div>
			</c:forEach>
		</div>


		<!-- If we need pagination -->
		<div class="swiper-pagination"></div>
		<!-- If we need navigation buttons -->
		<div class="swiper-button-prev swiper-button-white"></div>
		<div class="swiper-button-next swiper-button-white"></div>
	</section>


	<script src="${pageContext.request.contextPath }/resources/js/card.js"></script>

	<!-- card  end -->






	<!-- Page Content -->
	<div class="container" !import style="padding: 9%">

		<!-- Portfolio Item Heading -->
		<h1 class="my-4">
			<small>${eventboard.etitle}</small>

		</h1>

		<!-- Portfolio Item Row -->
		<div class="row">
			<c:url var="tUpFile" value="resources/eventFiles/" />
			<c:set var="eventNo" value="${eventboard.bno}" />

			<div class="col-md-8" id="titleImgArea">
				<img id="contentImg1" class="img-fluid"
					src="${tUpFile}${fileList[1].changeName}">

			</div>

			<div class="col-md-4">
				<h6 class="my-3">
					<p class="reply-content" readonly="readonly">${eventboard.econtent}</p>
				</h6>
			</div>

			</td> <br />
			<br />
			<br />
			<c:if test="${member.mlevel eq '2'}">
				<h8 class="my-3">
				<button class="button"
					onclick="location.href='${pageContext.request.contextPath}/DEBoard.do?bno='+${eventNo}">삭제하기</button>
				&nbsp;&nbsp;
				<button class="button"
					onclick="location.href='${pageContext.request.contextPath}/tUpView.ttn?bno='+${eventNo}">수정하기</button>
				&nbsp;&nbsp; </h8>
				<h8 class="my-3">
				<button class="button"
					onclick="location.href='${pageContext.request.contextPath}/ListEventboard.do'">메뉴로
					돌아가기</button>
				&nbsp;&nbsp; </h8>
			</c:if>
		</div>




		<div class="replyWriteArea">
			<form action="${pageContext.request.contextPath }/insert.cco"
				method="post">
				<!--<input type="hidden" name="writer" value="${event.bno}"/>  -->
				<input type="hidden" name="bno" value="${eventboard.bno}" /> <input
					type="hidden" name="cwriter" value="${member.userNo}" /> <br />
				<br />
				<c:if test="${!empty member}">
					<tr>
						<td>댓글 작성</td>
						<td><textArea rows="3" cols="70" id="replyContent"
								name="replyContent"></textArea></td>
					</tr>



					<button class="button" type="submit" id="addReply">댓글 등록</button>

				</c:if>
			</form>
		</div>
		<div id="replySeletArea">


			<c:forEach var="bco" items="${ clist }">
				<table id="replySelectTable" style="pitch-range: inherit;">

					<hr />

					<ul class="cards">
						<li class="card"><span class="replyText">${bco.ccontent}</span>
							&nbsp;&nbsp;<br /> <br />작성자 : ${bco.userName} <br /> <br />
							<!-- date 내가 원하는 모양으로 표현 (format)-->
							<div align="right">
								<fmt:formatDate value="${bco.cdate}" pattern="yyyy-MM-dd HH:mm" />
							</div> <c:if test="${member.userNo eq bco.cwriter}">
								<div class="row">
									<div class="col-7"></div>
									<div class="col-5">
										<input type="hidden" name="cno" value="${bco.cno}" />
										<button class="button deleteBtn" onclick="deleteReply(this);">삭제하기</button>
										<button class="button updateBtn" onclick="updateReply(this);">수정하기</button>
										<button class="button updateConfirmBtn" style="display: none;"
											onclick="updateConfirm(this);">수정완료</button>
									</div>
								</div>
							</c:if></li>

					</ul>
				</table>

				<br />

				<!-- 내가 쓴 글만 삭제하기. -->

			</c:forEach>
		</div>
		<!-- 댓글 끝 -->


		<script>
			var bno = '${eventboard.bno}';

			// 댓글 삭제 함수
			function deleteReply(obj) {
				var cno = $(obj).siblings('input').val();

				location.href = "${pageContext.request.contextPath}/delete.cco?cno="
						+ cno + "&bno=" + bno;
			}

			// 댓글 수정함수 
			function updateReply(obj) {
				//현재 위치와 가장 가까운 span 가져오기
				var $span = $(obj).parents('li').find('span');
				var content = $span.text();
				$span.empty();

				$span.append($('<textarea>').text(content));

				// 수정 완료 버튼 보여주기
				$(obj).siblings('.updateConfirmBtn').css('display', 'inline');

				// 수정하기는 숨기기
				$(obj).css('display', 'none');

			}
			// 수정 완료 기능 구현 함수
			function updateConfirm(obj) {
				// 댓글 내용 가져오기
				var $span = $(obj).parents('li').find('span');
				var $textarea = $(obj).parents('li').find('span').children(
						'textarea');
				var content = $textarea.val();

				$span.empty();
				$span.append(content);

				// 댓글 번호 가져오기
				var cno = $(obj).siblings('input').val();
				/*
				location.href="${pageContext.request.contextPath}/Update.cco?cno="+cno+"&bno="+bno
				      +"&ccontent="+content;
				 */

				// 수정 완료 버튼 보여주기
				$(obj).siblings('.updateBtn').css('display', 'inline');

				// 수정하기는 숨기기
				$(obj).css('display', 'none');
			}
		</script>
		<script
			src='https://cdnjs.cloudflare.com/ajax/libs/cash/1.3.0/cash.min.js'></script>

		<script
			src="${pageContext.request.contextPath}/resources/js/comment.js"></script>
	</div>




	<c:import url="../common/footer.jsp" />
	<script src="${ pageContext.request.contextPath }/resources/assets/js/core/jquery.min.js"
	type="text/javascript"></script>
	<c:import url="../common/footerUtil.jsp" />
	

</body>
</html>