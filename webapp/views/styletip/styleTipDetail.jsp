<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StyleTip 상세 보기</title>
<c:import url="../common/commonUtil.jsp"/>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../../resources/css/bootstrap.min.css" type="text/css" id="bootstrap-css"> 

<style>
	.outer{
		align: center;
		background-color:#FEDDDF;
	}
	.content {
		background-color:white;
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
	.btn-circle.btn-lg:hover {
	  background-color: grey;
	  border-color: grey;
	}
	.btn-circle.btn-lg:active {
	  background-color: #ff666f;
	  border-color: #ff666f;
	}
	.likeBtn {
		position: absolute;
		position: fixed;
		right: 40px; 
		bottom: 50px;
	}
	.replyWriteContent{
		width: 800px;
		height: 38px;
		border-radius: 20px;
		border: 1px solid grey;
		resize: none;
		overflow-y:hidden;
		line-height:30px;
	}
	.replyViewContent{
		width: 800px;
		height: 38px; 
		border-radius: 20px;
		border: 1px solid #ff666f;
		background: #FCEAEB;
		color: black;
		resize: none;
		padding-top: 5px;
	}
	.btn-circle.btn-lg-r {
	  width: 30px;
	  height: 30px;
	  padding: 2px 2px;
	  font-size: 15px;
	  line-height: 1.33;
	  border-radius: 25px;
	  background-color: #ff666f;
	  border-color: #ff666f;
	  cursor: pointer;
	}
	#like {
		background: white;
    	border: 1px solid white;
	  	font-size: 30px;
	}
	#likeheart {
		width: 80px;
	  	height: 100px;
	  	color: #ff666f;
	  	cursor: pointer;
	  	font-size: 40px; 	  
	}
	.countlike{
		float: left;
		
	}
	.allCountlike {
		display: inline-block;
	}
</style>
	<c:import url="../common/headerUtil.jsp"/>
</head>
<body>
	<c:import url="../common/header.jsp"/>
	
	
	<section class="outer" align="center">
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		
		<div class="likeBtn">
			<%-- <c:if test="${member.mlevel eq 1 }">  --%>
			<c:if test="${likechk eq 0 }">
			<!-- <button type="button" class="btn btn-primary likeoff" id="like"> -->
				<i class="glyphicon glyphicon-heart-empty likeoff like" id="likeheart"></i>
			<!-- </button> --> </c:if>
			<c:if test="${likechk ne 0 }">
			<!-- <button type="button" class="btn btn-primary likeon" id="like"> -->
				<i class="glyphicon glyphicon-heart likeon like" id="likeheart"></i>
			<!-- </button> --> </c:if>
			<%-- </c:if> --%>
		</div>
		<c:set var="thumbNo" value="${ StyleTip.bno }"/> 
		
		
		<div class="title">
			<h1>${ StyleTip.ttitle }</h1>
		</div>
		
		<div class="allCountlike">
			<div class="countlike">
				조회수 : ${ StyleTip.tcount } &nbsp; &nbsp; &nbsp;
				등록일 : ${ StyleTip.tdate } &nbsp; &nbsp; &nbsp;
			</div>
			<div class="countlike">좋아요 : &nbsp;</div>
			<div class="countlike" id="likeCount">${ likecount }</div>
		</div>
		
		<br />
		<br />
		<br />
		<br />
		
		<div class="content">
			${ StyleTip.tcontent }
		</div>
		
		<br /><br /><br />
		
		<c:if test="${empty member or member.mlevel eq 1 }">
			<button type="button" class="btn btn-primary btn-circle btn-lg" onclick="goList();">
				<i class="glyphicon glyphicon-list"></i>
			</button>&nbsp;&nbsp;&nbsp;
		</c:if>
		<!-- 관리자만 버튼 볼 수 있도록 -->
		<%-- <c:if test="${member.mlevel eq 2 }"> --%>
			<button type="button" class="btn btn-success btn-circle btn-lg" onclick="goUpdate();">
				<i class="glyphicon glyphicon-pencil"></i>
			</button>&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-info btn-circle btn-lg" onclick="goDelete();">
				<i class="glyphicon glyphicon-trash"></i>
			</button>
		<%-- </c:if> --%>
		
		<br /><br /><br /><br />
				
		<div class="replyArea" align="center">
			<div class="replyWriteArea">
				<form action="${pageContext.request.contextPath }/insertco.st" method="post">
					<input type="hidden" name="writer" value="${ member.userNo }"/>
					<input type="hidden" name="bno" value="${ StyleTip.bno }" />
					
					<textarea class="replyWriteContent" name="replyContent" placeholder="   댓글 추가.."
						onkeyup="this.style.height='26px'; this.style.height = this.scrollHeight + 'px';"></textarea>
					
					<%-- <c:if test=" ${ !empty member }"> --%>
					<button type="submit" class="btn btn-success btn-circle btn-lg-r">
						<i class="glyphicon glyphicon-ok"></i>
					</button>
					<%-- </c:if> --%>
					
				</form>
			</div>
			
			<br /><br /><br />
			
			<div id="replyViewArea">
				<c:if test="${ !empty clist }">
				<div>
		   		<c:forEach var="bco" items="${ clist }">
		   		<div>
		   			<textarea class="replyViewContent" readonly="readonly">&nbsp;&nbsp;${bco.ccontent}</textarea>
					<textarea class="replyOrigin" style="display : none;"></textarea>
					
					
					<c:set var="readonly" value="${bco.ccontent}"/>
					<c:set var="cbno" value="${bco.bno}"/>
					<c:set var="cwriter" value="${bco.cwriter}"/>
					<c:if test="${member.userNo eq bco.cwriter }">
						<input type="hidden" name="cno" value="${bco.cno}"/>
							  
						<button type="button" class="btn btn-success btn-circle btn-lg-r btn-update" onclick="updateReply(this);">
							<i class="glyphicon glyphicon-pencil replybtn"></i>
						</button>&nbsp;
						<button type="button" class="btn btn-success btn-circle btn-lg-r btn-return" style="display:none;" onclick="returnReply(this);">
							<i class="glyphicon glyphicon-repeat replybtn"></i>
						</button>
						<button type="button" class="btn btn-success btn-circle btn-lg-r btn-ok" style="display:none;" onclick="updateConfirm(this);">
							<i class="glyphicon glyphicon-ok replybtn"></i>
						</button>
						<button type="button" class="btn btn-success btn-circle btn-lg-r btn-remove" onclick="deleteReply(this);">
							<i class="glyphicon glyphicon-trash replybtn"></i>
						</button>
					
					</c:if>
				</div>
						<br />
		   		</c:forEach>
		   		</div>
		   		</c:if>
			</div>
		</div>
		
         <br />
         <br />
         <br />
         <br />
         <br />
         <br />
         <br />      
	</section>
	<script>
			// likechk 는 최초 1회만...
			var likechk = '${likechk}';
			
			var likeheart = $('#likeheart');
			
			$('.like').click(function(){
				var userNo = '${ member.userNo}';
				var bno = '${StyleTip.bno}';
				if(userNo == '' ){
					alert('로그인이 필요합니다.');
				} else {
					$.ajax({
						url : "likeon.st", // 전송할 주소 URL
						data : { bno : bno, 
								 userNo : userNo,
								 likechk : likechk }, // 서버에 전달할 값  
						type : "get",
						success : function(data){
							console.log(data);
							if(data != 0){
								likechk = data;
								$(".like").removeClass('likeoff');
								$(".like").addClass('likeon');
								alert("좋아요 되었습니다.");
								
								var alllike = $('#likeCount').html();
								$('#likeCount').html("");
								$('#likeCount').html(++alllike);
								
								$('.likeon').removeClass('glyphicon-heart-empty');
								$('.likeon').addClass('glyphicon-heart');
							} else {
								likechk = data;
								$(".like").removeClass('likeon');
								$(".like").addClass('likeoff');
								alert("좋아요가 취소 되었습니다.");
								
								var alllike = $('#likeCount').html();
								$('#likeCount').html("");
								$('#likeCount').html(alllike-1);
								
								$('.likeoff').removeClass('glyphicon-heart');
								$('.likeoff').addClass('glyphicon-heart-empty');
							}
							
						}, error : function(){ // 요청된 request정보와 상태
							console.log("좋아요 완전 실패!");
						}
					});
				}
			});
			
			
			/*$('.likeoff').click(function(){
				var userNo = '${ member.userNo}';
				var bno = '${StyleTip.bno}';
				if(userNo == '' ){
					alert('로그인이 필요합니다.');
				} else {
					$.ajax({
						url : "likeoff.st",
						data :  { bno : bno, 
							 	  userNo : userNo },
						type : "get",
						success : function(data){
							console.log("좋아요 취소!");
							alert("좋아요 취소되었습니다.");
							$('.likeoff').addClass('likeon');
							$('.likeoff').removeClass('likeoff');
						}, error : function(){
							console.log("좋아요 취소 실패!");
						}
					});
				}
			});*/
		</script>
	
	<script>
	
	var bno = '${cbno}';
	var cwriter = '${cwriter}';
	
	function updateReply(obj){
		// 반복 사용 줄이기
		var $replyViewContent = $(obj).siblings('.replyViewContent');
		$replyViewContent.removeAttr('readonly')
						 .css({border: '1px solid grey',
							   background: 'white'});
		$(obj).siblings('.btn-ok,.btn-return').css('display', 'inline');
		$(obj).css('display', 'none');
		$(obj).siblings('.replyOrigin').val($replyViewContent.text()); // 임시로 replyOrigin에 담아 두었다가, 취소하면 그 값을 다시 replyViewContent로..
	}
	
	function returnReply(obj){
		// 반복 사용 줄이기
		var $replyViewContent = $(obj).siblings('.replyViewContent');

		$replyViewContent.attr('readonly', 'readonly')
						 .css({border : '1px solid #d1cbd1',
							   background : '#d1cbd1'});
		// 이렇게 가져오면 값을 문자열 자체로 HTML로 바꾸어 가져오니까
		// Java Script에서 사용하는 변수의 값으로 변경해야 해요
		<%-- $(obj).siblings('.replyViewContent').val('${readonly}'); --%>
		$replyViewContent.val($(obj).siblings('.replyOrigin').val());
		$(obj).siblings('.btn-ok').css('display', 'none');
		$(obj).css('display', 'none');
		$(obj).siblings('.btn-update').css('display', 'inline');
	}
	
	function updateConfirm(obj) {
		// 댓글 내용 가져오기
		var content = $(obj).siblings('.replyViewContent').val();
		
		// 댓글 번호 가져오기
		var cno = $(obj).siblings('input').val();
		
		location.href="/facehair/updateco.st?cno="+cno+"&bno="+bno
				     +"&ccontent=" + content + "&userNo=${member.userNo}";
	}
	
	// 댓글 삭제 함수
	function deleteReply(obj){
		var answer = confirm("댓글을 삭제하시겠습니까?");
		
		if(answer == true){
			var cno = $(obj).siblings('input').val();
			location.href="/facehair/deleteco.st?cno="+cno+"&bno="+bno+"&userNo=${member.userNo}";
		}
	}
	
	
	
	function goList(){
		location.href='${pageContext.request.contextPath}/selectList.st';
	}

	function goUpdate(){
		location.href='${pageContext.request.contextPath}/UpView.st?bno=${thumbNo}';
		
	}
	
	function goDelete(){
		var answer = confirm("정말 삭제하시겠습니까?");
		if(answer == true){
			location.href='${pageContext.request.contextPath}/delete.st?bno=${thumbNo}';  <%-- 이렇게 써도 ${값}이 먼저 계산되어서 문제 없어요! --%>
		}
	}
	
	</script>
	
	<c:import url="../common/footer.jsp"/>
	<c:import url="../common/footerUtil.jsp"/>
	
</body>
</html>