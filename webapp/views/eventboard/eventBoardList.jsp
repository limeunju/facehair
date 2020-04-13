<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
 
<!DOCTYPE html>
<html>
<head>
<style>
.swiper-container {
  width: 25vw important;
  height: 30vw !important;
  transition: opacity .6s ease;
  position: relative !important;
  text-align: center;
  
}

#Xh2 {
	-webkit-font-smoothing: antialiased;
    font-family: "Montserrat", "Helvetica", Arial, sans-serif;
    font-weight: 300;
}
</style>



<!--검색창 css -->
   <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js'></script>

	<script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.2/angular-animate.min.js'></script>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/search.css"> 
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
 
 <!-- 검색창 css 끝 -->


<!-- 메인 swiper css -->
  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
  
  <script src="https://unpkg.com/swiper/js/swiper.js"></script>
  <script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<!--  메인 swiper css 끝 -->

 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.slim.min.js"></script>
<!--  <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<!--  <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script> -->

<meta charset="UTF-8">

<title>이벤트 게시판 목록화면</title>


<c:import url="../common/headerUtil.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/button.css" />

  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/card.css">
  
<style>
@import
	url(https://fonts.googleapis.com/css?family=Raleway:400,900,700,600,500,300,200,100,800)
	;

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
</style>
</head>



<body>

<c:import url="../common/header.jsp"/>

<script>
	// Top-N 분석 (최근 게시글 Top.5 / 인기상품 Top.5 / 조회수 Top.5)
	// Top 최근 게시글 목록 꺼내기
	/*
	$(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/top5.bo',
			type : 'get',
			success : function(data){
				console.log(data);
				
				var $appender = $('#swipe');
				// for each  하나의 원하는 게시물을 서버에서 가져온 data로 돌린다.
				for(var i in data){
					$appender.append(
							'<div class="swiper-slide" style="background-image:url(\'${pageContext.request.contextPath}/resources/eventFiles/' + data[i].bfile + '\')">'
						     + '<img src="${pageContext.request.contextPath}/resources/eventFiles/' + data[i].bfile + '" class="entity-img" />'
						     + '<div class="content">'
						     +  '<p class="title" data-swiper-parallax="-30%" data-swiper-parallax-scale=".7"></p>'
						     +  '<span class="caption" data-swiper-parallax="-20%"></span>'
						     + '</div></div>');
				}
				mySwiper.
			}, error : function(request){
				console.log("에러");
				console.log(request);
			
			}
			
		});
	});
	*/
	</script>

<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />





	<div class="row" align="center">
				<div style="margin-top:28px; position: relative; width: 100%; padding-right: 15px; padding-left: 15px;">
					<h2 id="Xh2"># Event</h2>
				</div>
			</div>

	<section class="swiper-container loading" style="margin-top:100px !important; width:300px; hegiht:200px; text-align:center" 
">

  <div class="swiper-wrapper" id="swipe">
  <c:forEach items="${ toplist }" var="top">
  	<div class="swiper-slide" style="background-image:url('${pageContext.request.contextPath}/resources/eventFiles/${top.bfile}"')">
	     <img src="${pageContext.request.contextPath}/resources/eventFiles/${top.bfile}" class="entity-img" />
	     <div class="content">
	     	<p class="title" data-swiper-parallax="-30%" data-swiper-parallax-scale=".7"></p>
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

<br /><br /><br /><br />
<!-- 검색  창  -->

<fieldset>
    <main ng-app="WikiApp" ng-controller="MainCtrl"  class="col-md-5">
     
            <form ng-submit="search()" method="post" action="${pageContext.request.contextPath}/ListEventboard.do">
                <input type="text" ng-model="searchTxt"/>
                <div class="eks" align="right"></div>
              
            </form>
            <p id="help"></p>
     
      
            <ul align="right">
            <a ng-href="{{eventBoardList.jsp}}" target="_blank" ng-repeat="result in results">
                <li>
                    <h1>{{evenetboard.title}}</h1>
                    <p>{{}}</p>
                </li>
                
            	</a>
                
                </ul>
        </main>
      </fieldset>  
<script src="${pageContext.request.contextPath }/resources/js/search.js"></script>

<!-- 검색창 끝 -->



  
    <br />
    <h2 align="center"> </h2>
    <c:forEach var="eventboard" items="${list}">
       <div class="row">
      	<div class="col-md-7" >
       	    <div class="thumbnailArea">
       			 <div class="thumb-list" id="thumbnail" align="center" >
          	       <input type="hidden" value="${eventboard.bno}">
           	 	   <img  class="img-fluid rounded mb-3 mb-md-0"
           	 	    src="${pageContext.request.contextPath}/resources/eventFiles/${eventboard.bfile}" > 
           		 </div>
      	   </div>
        </div>
   
      <div class="col-md-5" style="padding:5%">
        <div class="thumbnailArea">
      	  <div>
            	
            	<input type="hidden" value="${eventboard.bno}">
            	<h5>No. ${eventboard.bno} </h5>
            <br />
            	${eventboard.etitle}
      		<br />
      
       		 	    조회수 : ${eventboard.ecount}
			  	  
      	  </div>
       		   
           	 	
     		 <c:forEach var="eventboard" items="${list}">
     		 <div class="row">
      			 <div class="thumb-list" align="center">
         
          	      	<input type="hidden" value="${eventboard.bno}">
           	 	 
           		 </div>
   			 </div>
      		</c:forEach>
         </div>
      </div>
      </div>
      <hr>
      </c:forEach>
      
        
    	
    	<c:if test="${member.mlevel eq '2'}">
      
       <div class="containerr">

   		<a class="button" onclick="location.href='${ pageContext.request.contextPath }/views/eventboard/eventboardInsert.jsp'">작성하기 </a>
     
      </div>
     </c:if>
    
	
     
      <script>
      	$(function(){
      		$('.thumbnailArea').click(function(){
      			var bno = $(this).children().children().eq(0).val();	
      		
      			location.href='${ pageContext.request.contextPath }/SelectOneEboard.do?bno='+bno;
      			
      		});
      	});
      </script>


    <hr>


    <hr>

    <!-- Pagination -->
    <ul class="pagination justify-content-center" >
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Previous</span>
        </a>
      </li>
      <li class="page-item"  >
        <a class="page-link" href="#">1</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">2</a>
      </li>
  
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>
    </ul>

  </div>
  


	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/chatbox.js"></script>
 

  <!-- /.container -->
  
<c:import url="../common/footer.jsp"/>
<c:import url="../common/footerUtil.jsp"/>


</body>
</html>