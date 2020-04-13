<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>임시 Index</title>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
<%@ include file="views/common/headerUtil.jsp" %>
</head>

</head>

<body>

	
	<%@ include file="views/common/header.jsp" %>
	
	<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">

        <ol class="carousel-indicators">
            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" style="">
            <div class="carousel-item active">
            <a href="${ pageContext.request.contextPath }/selectList.st">
                <img src="${ pageContext.request.contextPath }/resources/assets/img/Bottle.png" class="d-block w-100" alt="...">

                <div class="carousel-caption d-none d-md-block" style="right: 70%; bottom: 30%;">
                    <h3>TIP</h3>
                    <p>적은 머리숱, 가는 모발, 곱슬머리, 손상 모발 케어 TIP</p>

                </div>
                </a>
            </div>
            <div class="carousel-item">
            <a href="${ pageContext.request.contextPath }/selectList.ta">
                <img src="${ pageContext.request.contextPath }/resources/assets/img/Cosmetics.png" class="d-block w-100" alt="...">

                <div class="carousel-caption d-none d-md-block" style="right: 70%; bottom: 30%;">
                    <h3>TALK</h3>
                    <p>'가성비甲' 연말 추천 헤어 ITEM은?</p>

                </div>
            </a>
            </div>
            <div class="carousel-item">
            <a href="${ pageContext.request.contextPath }/ListEventboard.do">
                <img src="${ pageContext.request.contextPath }/resources/assets/img/Mug.png" class="d-block w-100" alt="...">

                <div class="carousel-caption d-none d-md-block" style="right: 70%; bottom: 30%;">
                    <h3>EVENT</h3>

                    <p>홈페이지 런칭 기념 로고 머그컵 선착순 증정</p>
                </div>
            </a>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

   
   <%@ include file="views/common/footer.jsp" %>
   <%@ include file="views/common/footerUtil.jsp" %>
   
   <br />
   <br />
   <br />
   <br />
   <br />

</body>
</html>