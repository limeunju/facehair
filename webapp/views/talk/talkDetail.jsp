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
<style>

.Xcontent {
    min-height: calc(100vh - 20px);
}

body {
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
	font-family: 'Overpass', sans-serif;
	letter-spacing: 0px;
	font-size: 17px;
	color: #8d8f90;
	font-weight: 400;
	line-height: 32px;
	background-color: #edefef;
}

h1, h2, h3, h4, h5, h6 {
	color: #25292a;
	margin: 0px 0px 10px 0px;
	font-family: 'Overpass', sans-serif;
	font-weight: 700;
	letter-spacing: -1px;
	line-height: 1;
}

h1 {
	font-size: 34px;
}

h2 {
	font-size: 28px;
	line-height: 38px;
}

h3 {
	font-size: 22px;
	line-height: 32px;
}

h4 {
	font-size: 20px;
}

h5 {
	font-size: 17px;
}

h6 {
	font-size: 12px;
}

p {
	margin: 0 0 20px;
	line-height: 1.7;
}

p:last-child {
	margin: 0px;
}

ul, ol {
	
}

a {
	text-decoration: none;
	color: #8d8f90;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

a:focus, a:hover {
	text-decoration: none;
	color: #f85759;
}

.page-header {
	position: relative;
	min-height: 30% !important;
	z-index: 0 !important;
	background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F) center fixed !important;
	background-size: 400% 400% !important;
	animation: gradientBG 15s ease infinite !important;
}



@keyframes gradientBG {
	0% {
		background-position: 0% 50% ;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

.page-caption {
	padding-top: 170px;
	padding-bottom: 174px;
}

.page-title {
	font-size: 46px;
	line-height: 1;
	color: #fff;
	font-weight: 600;
	text-align: center;
}

.card-section {
	position: relative;
	bottom: 60px;
}

.card-block {
	padding: 80px;
}

.section-title {
	margin-bottom: 60px;
}

.btn {
	font-size: 18px !important;
	/* padding: 2px !important; */
	padding: 0.5rem 10px !important;
}

.timestamp {
	background: aliceblue;
	padding: 5px 15px;
	border-radius: 100px;
	font-size: 15px !important;
}

#panel-title {
	font-size: 1.8em;
}

.panel-header {
	background-color: #ff666f;
	color: white;
	padding: 1%;
}

.panel-collapse {
	background-color: #ffffff;
	box-shadow: 0px 3px 5px -3px black;
	padding: 3% 4%;
}

.comment {
	border-left: 4px solid #ff666f;
	padding: 0 1% 1% 3%;
	margin-bottom: 5%;
}

.comment-header {
	margin-bottom: 1%;
}

.panel-collapse .icon {
	width: 3%;
	margin-right: 0.5%;
}

.panel-collapse small {
	color: #777;
}

.formtitle {
	font-size: 1.8em;
	float: left;
}

#author:focus, textarea:focus {
	border-bottom: 1px solid #3f51b5;
}

textarea {
	resize: none;
	height: 150px !important;
}

.commentButton {
	border: 0px solid;
	background-color: #3f51b5;
	color: white;
	padding: 1%;
	box-shadow: 0 2px 5px black;
	width: 25%;
}

.reply-content {
	height: 100px !important;
}
</style>
<%@ include file="../common/headerUtil.jsp"%>

<link href='https://fonts.googleapis.com/css?family=Noto+Sans'
	rel='stylesheet' type='text/css'>
</head>
<body>

	<%@ include file="../common/header.jsp"%>


	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="page-caption">
						<h1 class="page-title"></h1>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="card-section">
		<div class="container">
			<div class="card-block bg-white mb30">
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<!-- section-title -->
						<div class="section-title mb-0">

							<div style="display: inline-flex;">
								<p style="margin: auto;">
									<img class="img-circle"
										src="${pageContext.request.contextPath }/resources/images/unnamed.png"
										alt="User Image">
								</p>
								&nbsp;&nbsp; &nbsp;&nbsp;
								<p style="margin: auto; font-size: 20px;">
									익명 <br /> <span class="timestamp">🕔<strong>
											${talk.tDate} </strong></span>
								</p>



							</div>
							<div>
								<h2>${talk.tTitle}</h2>
								<br />
								<pre
									style="font-family: 'Quicksand', sans-serif; font-size: 20px; word-wrap: break-word; white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap; word-break: break-all;">${talk.tContent}</pre>
								<div style="padding: 4px;">
									<p style="float: left; font-size: 20px; padding: 4px;">
										<i class="fas fa-eye" aria-hidden="true"></i> ${ talk.tCount }
									</p>
									<div style="display: inline-flex; float: right;">
										
										<c:if test="${ !empty member and member.userNo != talk.writer }">
											<button class="btn btn-warning"
												onclick="talkReport();">
												<i class="fas fa-angry"></i>
												<!-- 신고하기 -->
											</button>
											
										</c:if>
										
										<c:if
											test="${ !empty member and member.userNo eq talk.writer }">

											<c:url var="talkUpdate" value="tUpView.ta">
												<c:param name="bno" value="${talk.bno }" />
											</c:url>

											<button class="btn btn-warning"
												onclick="location.href='${talkUpdate}'">
												<i class="fas fa-pencil-square-o"> </i>
												<!-- 수정하기 -->
											</button>
												
											&nbsp;
											
											<button class="btn btn-danger" onclick="deleteTalk();">
												<i class="fas fa-times-circle"> </i>
												<!-- 삭제하기 -->
											</button>
										</c:if>

										&nbsp;

										<button class="btn btn-primary"
											onclick="location.href='${pageContext.request.contextPath }/selectList.ta'">
											<i class="fas fa-undo"></i>
											<!-- 목록으로 돌아가기 -->
										</button>


									</div>
								</div>
							</div>
						</div>

						<br /> <br />

						<hr />

						<!-- --------------------------------------------------------------------------------------------- -->


						<div class=" panel-header">
							<span id="panel-title">댓글 <i class="fas fa-comments"></i>
							</span>
						</div>

						<div class="panel-collapse">
							<c:if test="${ !empty clist }">
								<c:forEach var="tco" items="${ clist }">

									<div class="comment">
										<input type="hidden" name="userNo" value="${ tco.cwriter }" />
										<div class="comment-header" style="font-size: 18px;">
											<img class="img-circle"
												src="${pageContext.request.contextPath }/resources/images/unnamed.png"
												alt="User Image">

											<div style="display: inline-flex; float: right;">

												<c:if test="${member.userNo eq tco.cwriter }">

													<input type="hidden" name="cno" value="${tco.cno}" />

													<button type="button"
														class="btn-sm btn-warning updateReplyBtn"
														onclick="updateReply(this);">
														<i class="fas fa-pencil-square-o"> </i>
														<!-- 수정하기 -->
													</button>

													<button type="butotn"
														class="btn-sm btn-success updateReplyConfirm"
														onclick="updateConfirm(this);" style="display: none;">
														<i class="fas fa-pencil-square-o"> </i>
														<!-- 수정완료 -->
													</button>
												
													&nbsp;
											
													<button type="butotn"
														class="btn-sm btn-danger deleteReplyBtn"
														onclick="deleteReply(this);">
														<i class="fas fa-times-circle"> </i>
														<!-- 삭제하기 -->
													</button>
												</c:if>


											</div>

											<p style="display: inline-block; margin: 10px;">

												<c:if test="${ talk.writer == tco.cwriter }">
													<span style="color: #ff666f"><strong>글쓴이</strong></span>
												</c:if>
												<c:if test="${ talk.writer != tco.cwriter }">
													<span> 익명 </span>
												</c:if>

												<br /> <small class="timestamp">🕔 ${ tco.cdate } </small>
											</p>
										</div>

										<div class="comment-text" style="font-size: 18px;">

											<textarea class="form-control reply-content"
												readonly="readonly" style="resize: none;">${ tco.ccontent }</textarea>

										</div>


									</div>
								</c:forEach>
							</c:if>

							<br />

							<form action="${pageContext.request.contextPath }/insert.taco"
								method="post">
								<p class="formtitle">
									<i class="fas fa-comment"> </i>댓글 달기
								</p>
								<input type="hidden" name="userNo" value="${ member.userNo }" />
								<input type="hidden" name="bno" value="${talk.bno }" />
								<textarea class="form-control" name="replyContent"
									placeholder="댓글을 적어주세요"></textarea>
								<div class="row text-center">
									<div style="float: none; margin: 0 auto">
										<input class="btn-sm btn-success" style="margin: 10px;"
											type='submit' value='댓글작성' />
									</div>
								</div>
							</form>

						</div>
						<!-- --------------------------------------------------------------------------------------------- -->

					</div>
				</div>
			</div>
		</div>
	</div>


	<script>
		function deleteTalk() {
			var result = window.confirm("정말 삭제하십니까?");

			if (result) {

				<c:url var="talkDelete" value="delete.ta">
					<c:param name="bno" value="${talk.bno }" />
				</c:url>

				location.href = '${talkDelete}';
			}

		}
		
	
		// 게시글 번호를 전달할 전역 변수 생성
		var bno = ${talk.bno};
		
		// 게시글 신고 함수
		
		function talkReport() {
			location.href='${pageContext.request.contextPath}/viewReport.do?bno=' + bno;
		}
		
		// 댓글 수정 함수
		function updateReply(obj){
			// 현재 위치와 가장 가까운 textarea 가져오기
			$(obj).parent().parent().next().find('textarea')
			.removeAttr('readonly');
			
			// 수정 완료 버튼 보여주기
			$(obj).siblings('.updateReplyConfirm').css('display', 'inline');
			
			// 수정 하기는 숨기기
			$(obj).css('display', 'none');
		}
		
		// 수정 완료 기능 구현 함수
		function updateConfirm(obj) {
			// 댓글 내용 가져오기
			
			var content = $(obj).parent().parent().next().find('textarea').val();
			
			var enContent = encodeURIComponent(content);
			
			// alert(content);
			
			// 댓글 번호 가져오기
			var cno = $(obj).siblings('input').val();
			
			location.href="${pageContext.request.contextPath}/update.taco?cno="+cno+"&bno="+bno+"&ccontent="+enContent;
		}
		
		// 댓글 삭제 함수
		function deleteReply(obj){
			
			var cno = $(obj).siblings('input').val();
			
			location.href="${pageContext.request.contextPath }/delete.taco?cno="+cno+"&bno="+bno;
		}
		
	</script>

	<%@ include file="../common/footer.jsp"%>
	<%@ include file="../common/footerUtil.jsp"%>

</body>
</html>