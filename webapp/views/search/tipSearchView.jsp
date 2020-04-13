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
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> 
<style>
	@import url(https://fonts.googleapis.com/css?family=Raleway:400,900,700,600,500,300,200,100,800);

	h2 {
	    color: #4C4C4C;
	    word-spacing: 5px;
	    font-size: 40px;
	    font-weight: 700;	
	    margin-bottom:30px;
	    font-family: 'Raleway', sans-serif;
	}
	 
	
	
	.blog {
		align: center;
		background-color:#FEDDDF;
		padding:60px 0px;
	    font-family: 'Raleway', sans-serif;
	    
	}
	
	.blog .blog-column a{
	    color: #909090;
	    text-decoration: none;
	    font-size: 15px;
	}
	
	.blog .blog-column a:hover{
	    color: #909090;
	    text-decoration: underline;
	    font-weight:bold
	}
	
	.blog  span {
	    font-size: 22px;
	    font-weight: 700;
	}
	
	.blog  .blog-detail {
	    margin-top: 10px;
	    text-align: right;
	}
	
	.fa.fa-user, .fa.fa-clock-o {
	    padding-right: 10px;
	    color: #909090;
	    font-size: 11px;
	}
	.sideMargin {
		margin-right: 190px;
	}
	.blog-column {
		width: 480px;
		margin-bottom: 100px;
	}
	.rows {
		width: 1300px;
		margin: 0 auto;
	}
	.styleOne {
		display: block;
	}
	.uploadBtn {
		background: #ff666f;
		color: white;
		font-weight: bold;
		border-radius: 20px;
		border: 1px solid #ff666f;
		font-size: 15px;
	}
	.uploadBtn:hover {
		transform: scale(1.2, 1.2);
	}
	
</style>
	<c:import url="../common/header.jsp"/>
</head>
<body>
	<c:import url="../common/headerUtil.jsp"/>
	
	<div class="blog text-center">
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
		<input type="hidden" name="userNo" value="${member.userNo}">
    	<div class="container">
           
            <div class="row" align="center">
                 <div class="col-lg-6 col-lg-offset-3 text-center">  
                    <h2># Style Tip</h2>
                 </div> 
            </div>  
            
            <br /><br />

            
            <div align="center">
	            <button class="btn btn-default filter-button pickAll" data-filter="all" ">All</button>&nbsp;
	            <button class="btn btn-default filter-button women" data-filter="women"">Women</button>&nbsp;
	            <button class="btn btn-default filter-button men" data-filter="men" ">Men</button>
        	</div>
            
            <br />
            
            <div align="right">
            	<!-- 관리자만 버튼 볼 수 있도록 -->
            	<%-- <c:if test="${ member.mlevel eq 2}"> --%>
					<button onclick="location.href='/facehair/views/styletip/styleTipInsert.jsp'" class="uploadBtn">
						upload
					</button>
				<%-- </c:if> --%>
            </div>
            
            <br /><br /><br /><br />
            <!-- 
         		   처음 시작할 때 가져올 내용이 여기에 담긴다면,
         		   다음은 스크롤이 내려갔을 때 동작할 내용을 작성합니다.
             -->
            <div id="styleList" align="center">
			<c:forEach var="StyleTip" items="${list}" varStatus="status">
				<c:if test="${ status.index mod 2 eq 0 }">
					<div class="rows">
					</c:if>
					
					<c:if test="${StyleTip.tfilter eq 'A' }">
		 				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6 sideMargin styleOne styleAll" data-aos="fade-right">
		 			</c:if><c:if test="${StyleTip.tfilter eq 'F' }">
		 				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6 sideMargin styleOne styleWomen" data-aos="fade-right">
		 			</c:if><c:if test="${StyleTip.tfilter eq 'M' }">
		 				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6 sideMargin styleOne styleMen" data-aos="fade-right">
		 			</c:if>
		 			
						<input type="hidden" value="${StyleTip.bno}">
		                <div class="images">
							<c:out value="${StyleTip.imgTag}" escapeXml="false"/>
						</div>
						
						<div>
							<div class="blog-column">
								 <ul class="blog-detail list-inline"> 
									<li><i class="fa fa-user"></i>${StyleTip.tcount }</li> 
									<li><i class="fa fa-clock-o"></i>${StyleTip.tdate }</li> 
								</ul>
								<span>${StyleTip.ttitle }</span><br />
								<c:if test="${!empty member }">
								<a href="/facehair/selectOne.st?bno=${StyleTip.bno}&userNo=${member.userNo}">Read More</a>
								</c:if>
								<c:if test="${empty member }">
								<a href="${pageContext.request.contextPath}/views/common/errorPage.jsp">Read More</a>
								</c:if>
							</div>
						</div>
						
		            </div>
	            
	            <c:if test="${ status.index mod 2 ne 0 }">
				</div>
					
				</c:if>
             </c:forEach>
             </div>
		</div>
	
    </div>
    <script>
    	
    	var cunnrentPage = 1;
    	$(function(){
    		$('.images>img').attr('width', '480px').attr('height', '350px');
    		$('.images>img').attr('style', 'margin-right:10px');
    	});
    	
    	$('.pickAll').click(function(){
    		$('.styleAll').css('display', 'block');
    		$('.styleWomen').css('display', 'block');
    		$('.styleMen').css('display', 'block');
    	});
    	$('.women').click(function(){
    		$('.styleAll').css('display', 'none');
    		$('.styleWomen').css('display', 'block');
    		$('.styleMen').css('display', 'none');
    	});
    	$('.men').click(function(){
    		$('.styleAll').css('display', 'none');
    		$('.styleWomen').css('display', 'none');
    		$('.styleMen').css('display', 'block');
    	});

    	
    </script>
	<c:import url="../common/footer.jsp"/>
	<c:import url="../common/footerUtil.jsp"/>
</body>
</html>