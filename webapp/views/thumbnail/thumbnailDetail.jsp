<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 상세 보기</title>

<style>
	/*
*
* ===========================================================
*     HERO SECTION
* ===========================================================
*
*/
ul{
display:none;
}
.img-fluid {
height: 100%;
width :100%;
}
.hero {
  padding: 6.25rem 0px !important;
  margin: 0px !important;
}
.cardbox {
  border-radius: 3px;
  margin-bottom: 20px;
  padding: 0px !important;
}

/* ------------------------------- */
/* Cardbox Heading
---------------------------------- */
.cardbox .cardbox-heading {
  padding: 16px;
  margin: 0;
}
.cardbox .btn-flat.btn-flat-icon {
 border-radius: 50%;
 font-size: 24px;
 height: 32px;
 width: 32px;
 padding: 0;
 overflow: hidden;
 color: #fff !important;
 background: #b5b6b6;
 
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
text-align: center;
}
.cardbox .float-right .dropdown-menu{
  position: relative;
  left: 13px !important;  
}
.cardbox .float-right a:hover{
  background: #f4f4f4 !important;	
}
.cardbox .float-right a.dropdown-item {
  display: block;
  width: 100%;
  padding: 4px 0px 4px 10px;
  clear: both;
  font-weight: 400;
  font-family: 'Abhaya Libre', serif;
  font-size: 14px !important;
  color: #848484;
  text-align: inherit;
  white-space: nowrap;
  background: 0 0;
  border: 0;
}

/* ------------------------------- */
/* Media Section
---------------------------------- */
.media {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: start;
  align-items: flex-start;
}
.d-flex {
  display: -ms-flexbox !important;
  display: flex !important;
}
.media .mr-3{
  margin-right: 1rem !important;
}
.media img{
  width: 48px !important;
  height: 48px !important;
  padding: 2px;
  border: 2px solid #f4f4f4;
} 
.media-body {
  -ms-flex: 1;
  flex: 1;
  padding: .4rem !important;
}
.media-body p{
  font-family: 'Rokkitt', serif;	
  font-weight: 500 !important;
  font-size: 14px;
  color: #88898a;
}
.media-body small span{
  font-family: 'Rokkitt', serif;	
  font-size: 12px;
  color: #aaa;
  margin-right: 10px;
}


/* ------------------------------- */
/* Cardbox Item
---------------------------------- */
.cardbox .cardbox-item {
    position: relative;
    display: block;
}
.cardbox .cardbox-item img{
}
.img-responsive{
    display: block;
    max-width: 100%;
    height: auto;
}	
.fw {
    width: 100% !important;
	height: auto;
}


/* ------------------------------- */
/* Cardbox Base
---------------------------------- */
.cardbox-base{
 border-bottom: 2px solid #f4f4f4;
}	
.cardbox-base ul{
 margin: 10px 0px 10px 15px!important; 
 padding: 10px !important;
 font-size: 0px;	
  display: inline-block;
}
.cardbox-base li {
  list-style: none;
  margin: 0px 0px 0px -8px !important;
  padding: 0px 0px 0px 0px !important;
  display: inline-block;
}

.cardbox-base li a{
  margin: 0px !important;
  padding: 0px !important;
}
.cardbox-base li a i{
 position: relative;
 top: 4px; 
 font-size: 16px;
 color: #8d8d8d;
 margin-right: 15px;
}
.cardbox-base li a span{
 font-family: 'Rokkitt', serif;
 font-size: 14px;
 color: #8d8d8d;
 margin-left: 20px;
 position: relative;
 top: 5px; 
}
.cardbox-base li a em{
 font-family: 'Rokkitt', serif;
 font-size: 14px;
 color: #8d8d8d;
 position: relative;
 top: 3px; 
}
.cardbox-base li a img{
  width: 25px;
  height: 25px;
  margin: 0px !important;
  border: 2px solid #fff;
}


/* ------------------------------- */
/* Cardbox Comments
---------------------------------- */
.cardbox-comments{
  padding: 10px 40px 20px 40px !important;
  font-size: 0px;	
  text-align: center;
  display: inline-block;
}
.cardbox-comments .comment-avatar img{
  margin-top: 1px;
  margin-right: 10px;
  position: relative;
  display: inline-block;
  text-align: center;
  width: 40px;
  height: 40px;
}
.cardbox-comments .comment-body {
  overflow: auto;
}
.search {
 position: relative;
 right: -60px;
 top: -40px;
 margin-bottom: -40px;
 border: 2px solid #f4f4f4;	
 width: 100%;
 overflow: hidden;
}
.search input[type="text"] {
 background-color: #fff;
 line-height: 10px;
 padding: 15px 60px 20px 10px;
 border: none;
 border-radius: 4px;
 width: 350px;
 font-family: 'Rokkitt', serif;
 font-size: 14px;
 color: #8d8d8d;
 height: inherit;
 font-weight: 700;
}
.search button {
 position: absolute;
 right: 0;
 top: 0px;
 border: none;
 background-color: transparent;
 color: #bbbbbb;
 padding: 15px 25px;
 cursor: pointer;
 
 display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
text-align: center;
}
.search button i {
 font-size: 20px;
 line-height: 30px;
 display: block;
}
#contentArea {
		font-size :10pt;
		height:30px;
		text-indent: 20px;
		}

	}

/* ------------------------------- */
/* Author
---------------------------------- */
.author a{
 font-family: 'Rokkitt', serif;
 font-size: 16px;
 color: #00C4CF;
}
.author p{
 font-family: 'Rokkitt', serif;
 font-size: 16px;
 color: #8d8d8d;
}




#sidebar {
  width: 200px;
  height:300px;
  position: fixed;
  background: gold;
  z-index: 200;
  display: none;
}

#main-content {
  position: relative;
}
#content-wrapper {
  width: 30%;
  height: 100%;
  position: absolute;
  -ms-filter: alpha(opacity=100);
  filter: alpha(opacity=100);
  opacity: 0.1;
  -moz-opacity: 0.1;
  left: 70%;
  z-index: 200;
  display: none;
}
.navbar {
  cursor: pointer;
  color: red;
  z-index: 300;
  posit
  }

.Inner{
	width: 100px;
  height: 200px;
}

.Popup .Inner{
  display:none;
}

.updateBtn{
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

.updateConfirm{
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
	.deleteBtn{
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
	.insertBtn{
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
	#replySelectTable{
	padding: 15px;
  	margin: 0;
  	
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
		height: 30px;
		border-radius: 20px;
		border: 1px solid #ff666f;
		background: #FCEAEB;
		color: black;
		resize: none;
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
	/* .replybtn {
		border: 1px solid #ff666f;
		background-color: #FCEAEB;
	} */
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
	
</style>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../../resources/css/bootstrap.min.css" type="text/css" id="bootstrap-css"> 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600"><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
<link href="https://fonts.googleapis.com/css?family=Rokkitt" rel="stylesheet"> 
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->
</head>
<body>




		
	
	    <!-- ==============================================
	    Hero
	    =============================================== -->
        <section class="hero">
        
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
      
     <script>
			// likechk 는 최초 1회만...
			var likechk = '${likechk}';
			console.log(likechk);
			var likeheart = $('#likeheart');
			
			$('.like').click(function(){
				var writer = '${ member.userNo}';
				console.log(writer);
				
				var bno = '${thumbnail.bno}';
				console.log(bno);
				if(writer == '' ){
					alert('로그인이 필요합니다.');
				} else {
					$.ajax({
						url : "likeon2.st", // 전송할 주소 URL
						data : { bno : bno, 
								 userNo : writer,
								 likechk2 : likechk }, // 서버에 전달할 값  
						type : "get",
						success : function(data){
							console.log(data);
							if(data != 0){
								likechk = data;
								$(".like").removeClass('likeoff');
								$(".like").addClass('likeon');
								alert("좋아요 ♥");
								
								var alllike = parseInt($('#likeCount').html());
								$('#likeCount').html("");
								$('#likeCount').html((alllike+1) + " Likes");
								
								$('.likeon').removeClass('glyphicon-heart-empty');
								$('.likeon').addClass('glyphicon-heart');
							} else {
								likechk = data;
								$(".like").removeClass('likeon');
								$(".like").addClass('likeoff');
								alert("좋아요 X");
								
								var alllike = parseInt($('#likeCount').html());
								$('#likeCount').html("");
								$('#likeCount').html((alllike-1) + " Likes");
								
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
		
     
        
        
        	<c:url var="tUpFile" value="resources/thumbnailFiles/"/>
			<c:set var="thumbNo" value="${thumbnail.bno}"/>
         <div class="container">
          <div class="row">	
		  
		   <div class="col-lg-6 offset-lg-3">
			
			<div class="cardbox shadow-lg bg-white">
			 
			 <div class="cardbox-heading">
			 
			  <!-- START dropdown-->
			  
			<c:if test="${member.userNo eq thumbnail.writer}">	
 				<div class="dropdown float-right">
					<div class="Popup">
  						<div class="Btn">
  							<button class="btn btn-flat btn-flat-icon" type="button" data-toggle="dropdown" aria-expanded="false">
								<em class="fa fa-ellipsis-h"></em>
			   				</button>
			   			</div>
			   			
  						<div class="Inner">
    						<div class="fa fa-pencil" onclick="location.href='${pageContext.request.contextPath}/tUpView.tn?bno='+${thumbNo}">수정</div><br />
    						<div class="fa fa-trash-o" onclick="location.href='${pageContext.request.contextPath}/delete.tn?bno='+${thumbNo}">삭제</div>
  						</div>
							
  						
  					
  						
  						
					</div>
 				</div>
			</c:if>
			  <script>

			    $('.Popup .Btn').click(function() {
			        $('.Popup .Inner').css('position','absolute');
			        var $Inner = $(this).parent().children('.Popup .Inner');
			        $Inner.toggle();
			    });


			  
			  </script>
	  	<!--/ dropdown -->
	
			  <div class="media m-0">
			   <div class="d-flex mr-3">
				<a href=""><img class="img-fluid rounded-circle" src="${pageContext.request.contextPath }/resources/image/user1.png" alt="User"></a>
			   </div>
			   <div class="media-body">
			    <p class="m-0">${thumbnail.writer}</p>
				<small><span><i class="icon ion-md-pin"></i>${thumbnail.sdate}</span></small>
				<small><span><i class="icon ion-md-time"></i>${thumbnail.scount}</span></small>
			   </div>
			  </div><!--/ media -->
			  
			 </div><!--/ cardbox-heading -->
			  
			 <div class="cardbox-item">
			  <img class="img-fluid" src="${tUpFile}${fileList[0].changeName}" alt="Image">
			  	<div>
			  	<br />
					<p id="contentArea">${thumbnail.scontent}</p>
				</div>
			 </div><!--/ cardbox-item -->
			 <div class="cardbox-base">
			  <ul class="float-right">
			   <li><a><i class="fa fa-comments"></i></a></li>
			   <li><a><em class="mr-5">${ clist.size() }</em></a></li>
			   <li><a><i class="fa fa-share-alt"></i></a></li>
			   <li><a><em class="mr-3">0</em></a></li>
			  </ul>
			  <ul>
			   <li><a><i class="fa fa-heart"></i></a></li>
			   <li><a href="#"><img src="${pageContext.request.contextPath }/resources/image/user1.png" class="img-fluid rounded-circle" alt="User"></a></li>
			   <li><a href="#"><img src="${pageContext.request.contextPath }/resources/image/user1.png" class="img-fluid rounded-circle" alt="User"></a></li>
			   <li><a href="#"><img src="${pageContext.request.contextPath }/resources/image/user1.png" class="img-fluid rounded-circle" alt="User"></a></li>
			   <li><a href="#"><img src="${pageContext.request.contextPath }/resources/image/user1.png" class="img-fluid rounded-circle" alt="User"></a></li>
			   <li><a><span id="likeCount">${ likecount } Likes</span></a></li>
			  </ul>			   
			 </div>
			 
			 
			 
			 <!--/ cardbox-base 댓글 시작  -->
			<div class="replyArea">
			<div class="replyWriteArea">
				<form action="${pageContext.request.contextPath }/insert.co" method="post">
					<input type="hidden" name="writer" value="${ member.userNo }"/>
					<input type="hidden" name="bno" value="${thumbnail.bno }" />
					
			<!-- 댓글 작성 부분 -->
			 <div class="cardbox-comments">
			  <span class="comment-avatar float-left">
			   <a href=""><img class="rounded-circle" src="${pageContext.request.contextPath }/resources/image/user1.png" alt="..."></a>                            
        </span>
        
        <!-- 댓글칸 -->

			  <div class="search">
			   <input placeholder="write" type="text" id="replyContent" name="replyContent">
			   <button type="submit" id="addReply"><i class="fa fa-pencil"></i></button>
			  </div><!--/. Search -->
			 </div><!--/ cardbox-like -->			  
			</form>
			</div><!--/ cardbox -->	
			</div>
			
			<!-- 댓글 보여주는부분 -->
			<div id="replySelectArea">
				<c:if test="${ !empty clist }">
		   		<c:forEach var="bco" items="${ clist }">
		   			<table id="replySelectTable"
	      				 class="replyList">
				  		<tr>
				  			<td rowspan="2"> </td>
							<td><b>${bco.cwriter}</b></td>
							<td>${bco.cdate}</td>
							<td align="right">
							<c:if test="${member.userNo eq bco.cwriter }">
								<input type="hidden" name="cno" value="${bco.cno}"/>
									  
								<button type="button" class="updateBtn" 
									onclick="updateReply(this);">수정하기</button>
									
								<button type="button" class="updateConfirm"
									onclick="updateConfirm(this);"
									style="display:none;" >수정완료</button> &nbsp;&nbsp;
									
								<button type="button" class="deleteBtn"
									onclick="deleteReply(this);">삭제하기</button>
									
							</c:if>
							</td>
						</tr>
						<tr class="search">
							<td colspan="3" style="background : transparent;">
							<textarea class="reply-content" cols="100" rows="3"
							 readonly="readonly">${bco.ccontent}</textarea>
							</td>
						</tr>
					</table>
		   		</c:forEach>
		   </c:if>
			</div>
			
			
			<script>
		// 게시글 번호를 전달할 전역 변수 생성
		var bno = ${thumbnail.bno};
		
		// 댓글 수정 함수
		function updateReply(obj){
			// 현재 위치와 가장 가까운 textarea 가져오기
			$(obj).parent().parent().next().find('textarea')
			.removeAttr('readonly');
			
			// 수정 완료 버튼 보여주기
			$(obj).siblings('.updateConfirm').css('display', 'inline');
			
			// 수정 하기는 숨기기
			$(obj).css('display', 'none');
		}
		
		// 수정 완료 기능 구현 함수
		function updateConfirm(obj) {
			// 댓글 내용 가져오기
			
			var content 
			    = $(obj).parent().parent()
			      .next().find('textarea').val();
			
			// 댓글 번호 가져오기
			var cno = $(obj).siblings('input').val();
			
			location.href="/facehair/update.co?cno=" + cno + "&bno="+bno +"&userNo=" + ${member.userNo}
					     + "&ccontent=" + content;
		}
		
		// 댓글 삭제 함수
		function deleteReply(obj){
			
			var cno = $(obj).siblings('input').val();
			
			location.href="/facehair/delete.co?cno="+cno+ "&bno=" +bno + "&userNo=" + ${member.userNo};
		}
		
		
		</script> 
		
		
			</div><!--/ cardbox -->
			
           </div><!--/ col-lg-6 -->	
		   
			
          </div><!--/ row -->
         </div><!--/ container -->
         
        </section>
		
		<br />
		<br />
		<br />
		<br />
		<br />

</body>
</html>