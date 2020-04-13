<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수다방 게시판</title>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>

<style>
@import
	url(https://fonts.googleapis.com/css?family=Raleway:400,900,700,600,500,300,200,100,800)
	;

.Xcontent {
	min-height: calc(100vh - 20px);
}

body {
	margin: 0;
	width: 100%;
	height: 100vh;
	background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F)
		center fixed;
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}

@keyframes gradientBG { 0% {
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
#container {
	margin: 50px;
	font-family: 'Quicksand', sans-serif;
	font-size: 19px;
}

h2 {
	color: #4C4C4C;
	word-spacing: 5px;
	font-size: 40px !important;
	font-weight: 700;
	margin-bottom: 30px;
	font-family: 'Raleway', sans-serif;
}

.cards {
	margin-left: 14%;
}

.card {
	width: 300px;
	display: inline-block;
	background: white;
	padding: 30px;
	border-radius: 10px;
	margin: 10px;
	box-shadow: 0px 5px 0px 0px lightblue;
}

.badges {
	margin-top: 20px;
	text-align: center;
}

.timestamp {
	background: aliceblue;
	padding: 5px 15px;
	border-radius: 100px;
	font-size: 90%;
}

.content {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 18; /* 라인수 */
	-webkit-box-orient: vertical;
	word-wrap: break-word;
	line-height: 1.2em;
	max-height: 21.6em;
	/* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
}
</style>
<link href="https://fonts.googleapis.com/css?family=Quicksand:500"
	rel="stylesheet">
<script
	src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/headerUtil.jsp"%>


<div class="Xcontent">
	<div id="container">

			<div class="row" align="center">
				<div style="margin-top:28px; position: relative; width: 100%; padding-right: 15px; padding-left: 15px;">
					<h2># Talk</h2>
				</div>
			</div>

			<div style="margin-left: 14%;" s>
			<c:if test="${ !empty member }">
				<button class="btn btn-primary" type="button" 
					onclick="location.href='${ pageContext.request.contextPath }/views/talk/talkInsertForm.jsp';">글쓰기</button>
			</c:if>
		</div>

		
		<br />
		
		<div class="cards" data-masonry='{ "itemSelector": ".card"}'>
			<c:forEach var="talk" items="${list}">
				<div class="card">
					<input type="hidden" value="${talk.bno}" />
					<div style="font-size: 23px; color: #ff666f">
						<b>${talk.tTitle}</b>
					</div>
					<pre
						style="font-family: 'Quicksand', sans-serif; font-size: 15px; word-wrap: break-word; white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap; word-break: break-all;"
						class="content">${talk.tContent}</pre>
					<div class="badges">
						<span class="timestamp">🕔 ${talk.tDate}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		

		<br />
		<br />
	<div class="row text-center">
		<div class="pagingArea" style="float:none; margin: 0 auto;" >
			<c:url var="selectList" value="selectList.ta" />

			<!-- 처음 페이지 버튼 -->
			<button class="btn"
				onclick="location.href='${selectList}?currentPage=1'">
				&lt;&lt;</button>

			<!-- 이전 페이지 버튼 -->
			<c:if test="${ pi.currentPage le 1 }">
				<button class="btn" disabled>&lt;</button>
			</c:if>
			<c:if test="${ pi.currentPage gt 1 }">
				<button class="btn"
					onclick="location.href='${selectList}?currentPage=${pi.currentPage - 1}'">
					&lt;</button>
			</c:if>

			<!-- 상세 페이지 구현을 위한 반복문 -->
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage}">
				<c:if test="${p eq pi.currentPage }">
					<button class="btn" disabled>
						<b>${p}</b>
					</button>
				</c:if>
				<c:if test="${ p ne pi.currentPage}">
					<button class="btn"
						onclick="location.href='${selectList}?currentPage=${p}'">
						${p}</button>
				</c:if>
			</c:forEach>


			<!-- 다음 페이지 버튼 -->
			<c:if test="${ pi.currentPage ge pi.maxPage }">
				<button class="btn" disabled>&gt;</button>
			</c:if>
			<c:if test="${ pi.currentPage lt pi.maxPage }">
				<button class="btn"
					onclick="location.href='${selectList}?currentPage=${pi.currentPage + 1}'">
					&gt;</button>
			</c:if>

			<!-- 마지막 페이지 버튼 -->
			<button class="btn"
				onclick="location.href='${selectList}?currentPage=${pi.maxPage}'">
				&gt;&gt;</button>
		</div>
	</div>
		<script>
			$(function() {
				$(".card")
						.click(
								function() {
									var bno = $(this).find("input").val();
									location.href = "${pageContext.request.contextPath}/selectOne.ta?bno="
											+ bno;
								});
			});
		</script>

	</div>

	
	<br />
</div>
	<%@ include file="../common/footer.jsp"%>
	<%@ include file="../common/footerUtil.jsp"%>

</body>
</html>