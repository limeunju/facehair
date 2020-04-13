<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
 
<!DOCTYPE html>
<html>
<head>

<!-- chatbox css -->

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/chatbox.css">
    
<!-- chatbox end -->

<!--검색창 css -->
   <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js'></script>

	<script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.2/angular-animate.min.js'></script>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/search.css"> 
 
 <!-- 검색창 css 끝 -->

<!-- 메인 swiper css -->
  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
  <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
  
  <script src="https://unpkg.com/swiper/js/swiper.js"></script>
  <script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<!--  메인 swiper css 끝 -->

 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.slim.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

<meta charset="UTF-8">

<title>이벤트 게시판 목록화면</title>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>

<c:import url="../common/headerUtil.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/button.css" />

  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/card.css">
  

</head>



<body>



<c:import url="../common/header.jsp"/>


<section class="swiper-container loading">
  <div class="swiper-wrapper">
    <div class="swiper-slide" style="background-image:url(https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLbVhsNzdIYmlfN1E)">
      <img src="https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLbVhsNzdIYmlfN1E" class="entity-img" />
      <div class="content">
        <p class="title" data-swiper-parallax="-30%" data-swiper-parallax-scale=".7"></p>
        <span class="caption" data-swiper-parallax="-20%"></span>
      </div>
    </div>
    <div class="swiper-slide" style="background-image:url(https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLWTdaX3J5b1VueDg)">
      <img src="https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLWTdaX3J5b1VueDg" class="entity-img" />
      <div class="content">
        <p class="title" data-swiper-parallax="-30%" data-swiper-parallax-scale=".7"></p>
        <span class="caption" data-swiper-parallax="-20%"></span>
      </div>
    </div>
    <div class="swiper-slide" style="background-image:url(https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLRml1b3B6eXVqQ2s)">
      <img src="https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLRml1b3B6eXVqQ2s" class="entity-img" />
      <div class="content">
        <p class="title" data-swiper-parallax="-30%" data-swiper-parallax-scale=".7"></p>
        <span class="caption" data-swiper-parallax="-20%"></span>
      </div>
    </div>
    <div class="swiper-slide" style="background-image:url(https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLVUpEems2ZXpHYVk)">
      <img src="https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLVUpEems2ZXpHYVk" class="entity-img" />
      <div class="content">
        <p class="title" data-swiper-parallax="-30%" data-swiper-parallax-scale=".7"></p>
        <span class="caption" data-swiper-parallax="-20%"></span>
      </div>
    </div>
    <div class="swiper-slide" style="background-image:url(https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLNXBIcEdOUFVIWmM)">
      <img src="https://drive.google.com/uc?export=view&id=0B_koKn2rKOkLNXBIcEdOUFVIWmM" class="entity-img" />
      <div class="content">
        <p class="title" data-swiper-parallax="-30%" data-swiper-parallax-scale=".7"></p>
        <span class="caption" data-swiper-parallax="-20%"></span>
      </div>
    </div>
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
        <div class="wrapper fullHeight" id="search">
            <form ng-submit="search()" action="${pageContext.request.contextPath}/ListEventboard.do">
                <input type="text" ng-model="searchTxt"/>
                <div class="eks" align="right"></div>
            </form>
            <p id="help"></p>
        </div>
        <div class="wrapper">
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




<!-- <div class="container" !import style="padding: 10%"> -->

<!--     Page Heading -->
<!--     <h2 class="my-4" align="center">이벤트 목록</h2> -->

<!--     Project One -->

<!--       <div class="col-md-5"> -->
<!--         <h3></h3> -->
<!--         <p></p> -->
    
<!--       </div> -->
<!--     </div> -->
    

    <br />
    <h2 align="center"> </h2>
    <c:forEach var="eventboard" items="${list}">
       <div class="row">
      	<div class="col-md-7"  style="padding:5%">
       	    <div class="thumbnailArea">
       			 <div class="thumb-list" id="thumbnail" align="center" >
          	       <input type="hidden" value="${eventboard.bno}">
           	 	   <img  class="img-fluid rounded mb-3 mb-md-0"
           	 	    src="/eventMyProject/resources/eventFiles/${eventboard.bfile}" > 
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
      
        
    	
    	<c:if test="${!empty member}">
      
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
        <a class="page-link" href="#">3</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>
    </ul>

  </div>
  
 <!-- 채팅창 -->
    <div id="live-chat">
        
        <header class="clearfix">
            
            <a href="#" class="chat-close">x</a>

            <h4></h4>
            
        </header>

        <div class="chat">
            
            <div class="chat-history" >
                
                <div class="chat-message clearfix" >
                    
           
                    <div class="chat-message-content clearfix" >
                        
                        <span class="chat-time"></span>

                  
                    </div> <!-- end chat-message-content -->

                </div> <!-- end chat-message -->

            </div> <!-- end chat-history -->

            <p class="chat-feedback"></p>

           

                <fieldset>
                    <div id="messageWindow"></div> <br>
          
                    <input  type="text" autofocus>

                    
                    <input type="hidden">

                </fieldset>

           
        </div> <!-- end chat -->

    </div> <!-- end live-chat -->

	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/chatbox.js"></script>
  
  
  
  
  
  <!-- /.container -->
<c:import url="../common/footer.jsp"/>
<c:import url="../common/footerUtil.jsp"/>

</body>
</html>